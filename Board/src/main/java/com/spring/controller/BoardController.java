package com.spring.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.AttachFileVO;
import com.spring.domain.BoardVO;
import com.spring.domain.Criteria;
import com.spring.domain.PageVO;
import com.spring.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Autowired
	private BoardService service;
	
	@PreAuthorize("isAuthenticated()") //인증된 사용자인 경우 true
	@GetMapping("/register")
	public void register() {
		log.info("레지스터 폼");
	}
	
	//글 등록하기
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/register")
	public String registerPost(BoardVO vo,RedirectAttributes rttr) {
		log.info("글 등록 요청"+vo);
		
		//파일 확인
		if(vo.getAttachList()!=null) {
			vo.getAttachList().forEach(attach -> log.info(attach+""));
		}
		
		try {
			boolean regi = service.register(vo);
			if(regi) {
				rttr.addFlashAttribute("result", vo.getBno());
				return "redirect:/board/list"; //URL의 변화여부가 필요하다면 Redirect를 사용하는 것이 좋습니다.
												//객체를 재사용하거나 공유해야한다면 Forward를 사용하는 것이 좋습니다.
			}else {	
				return "/board/register";	
			}
		} catch (Exception e) {
			return "redirect:/board/list";
		}
//		return "redirect:/board/list";		
	}
	
	//읽기,읽기에서 수정으로
	@GetMapping(value= {"/read","/modify"})
	public void read(BoardVO vo,@ModelAttribute("cri") Criteria cri,Model model) {
		log.info(""+vo);
		log.info(""+cri);
		
		BoardVO read = service.read(vo);
		model.addAttribute("vo", read);
		//http://localhost:8080/board/read
		//http://localhost:8080/board/modify
	}
	
	
	@GetMapping("/list")
	//cri 안에만 담아주면 됨 컨트롤러는 이것 만 씀
	//model cri 이름으로 계속 유지
	public String list(@ModelAttribute("cri") Criteria cri,Model model) { 
		log.info("회원가입 페이지 동작");
		
		//현재 페이지에 보여줄 게시물
		List<BoardVO> list = service.list(cri);
		model.addAttribute("list", list);
		
		//페이지 하단의 페이지 나누기와 관련된 정보들
		int total = service.total(cri);
		model.addAttribute("pageVO", new PageVO(cri,total));
		
		return "/board/list";
	}
	
	//두번 작업할 필요 없음
//	@GetMapping("/modify")
//	public String modify(BoardVO vo,Model model) {
//		log.info(""+vo);
//		
//		BoardVO modify = service.read(vo);
//		model.addAttribute("vo", modify);
//		
//		return "/board/modify";
//	}
	
	//내용 수정
	@PreAuthorize("principal.username == #vo.writer")
	@PostMapping("/modify")
	public String modifyPost(Criteria cri,BoardVO modify,RedirectAttributes rttr) {
		log.info(""+cri);
		log.info(""+modify);
		

		boolean modi = service.modify(modify);
		
		if(modi) {
			//flash : 딸라 어쩌구 저쩌구 파라미터 방식으로 넘겨야함
			//read를 파라미터로 넘겨서 밑에서도 파라미터로 넘어갈수 있게 그냥 어트리뷰트로 넘겨야함
 			rttr.addAttribute("bno", modify.getBno()); //flash는 세션에 담는 거기 때문에 그냥 어트리뷰트로 하면 url로 딸려보내진다  read?bno=3
 			rttr.addAttribute("pageNum",cri.getPageNum());
 			rttr.addAttribute("amount",cri.getAmount());
 			rttr.addAttribute("type",cri.getType());
 			rttr.addAttribute("keyword",cri.getKeyword());
			return "redirect:/board/read"; //?bno=+modify.getBno();
		}else {
			rttr.addAttribute("bno", modify.getBno());
			rttr.addAttribute("pageNum",cri.getPageNum());
			rttr.addAttribute("amount",cri.getAmount());
			rttr.addAttribute("type",cri.getType());
 			rttr.addAttribute("keyword",cri.getKeyword());
			return "redirect:/board/modify";
		}
	}
	
	//내용 삭제
	@PreAuthorize("principal.username == #writer")
	@PostMapping("/remove")
	public String delete(BoardVO vo,String writer,int bno,RedirectAttributes rttr,Criteria cri) {
		
		//현재 글번호에 해당하는 첨부파일 목록을 서버에서 삭제하기 위해서 bno에 해당하는 첨부파일 리스트 가져오기
		List<AttachFileVO> attachList = service.attachList(bno);
		
		boolean del = service.delete(bno);		
		deleteFiles(attachList);
		if(del) {
			rttr.addAttribute("pageNum",cri.getPageNum());
 			rttr.addAttribute("amount",cri.getAmount());
 			rttr.addAttribute("type",cri.getType());
 			rttr.addAttribute("keyword",cri.getKeyword());
 			rttr.addFlashAttribute("result", "success");
			return "redirect:/board/list";
		}
		
		rttr.addAttribute("bno", vo.getBno());
		return "/board/modify";
	}
	
	//첨부물 가져오기 컨트롤러 작성
	//put과 delete 는 반드시 json의 형태로 보내야 한다
	//get과 post는 파라미터 처리해서 보내면 됨
	
	//put이나 delete는 애네 데이터를 보낼라면 @responsbody를 써야함
	//rest과 그냥 컨트롤러의 차이점은 rest는 return하는 타입이 jsp가 아니다 타입을 던지면 그대로 데이터로 받아들인다.
	
	//ResponseEntity : 데이터를 보내면서 내가 상태코드를 같이 보낼수 있다. 상태코드를 무엇을 보내냐에 따라 에러로 처리
	//컨트롤어노테이션에 @responsebody를 보내면 jsp가 아닌 그냥 list로 보낼수 있음
	
	@GetMapping("/getAttachList")
	public ResponseEntity<List<AttachFileVO>> getattachlist(int bno) {
		log.info("첨부물 가져오기 : " +bno);
		return new ResponseEntity<List<AttachFileVO>>(service.attachList(bno),HttpStatus.OK);
	}
	
	//게시글 삭제 시 서버 폴더에 첨부를 삭제
	private void deleteFiles(List<AttachFileVO> attachList) {
		if(attachList == null || attachList.size() == 0) {
			return;
		}
		
		for(AttachFileVO vo : attachList) {
			Path file = Paths.get("d:\\upload\\",vo.getUploadPath()+"\\"+vo.getUuid()+"_"+vo.getFileName());

			try {
				//일반파일, 이미지 원본 파일 삭제				
				Files.deleteIfExists(file);
				
				//썸네일 삭제
				if(Files.probeContentType(file).startsWith("image")) {
					Path thumb = Paths.get("d:\\upload\\",vo.getUploadPath()+"\\s_"+vo.getUuid()+"_"+vo.getFileName());
					Files.delete(thumb);
				}
			} catch (IOException e) {				
				e.printStackTrace();
			}
			
		}
	}	
}

















