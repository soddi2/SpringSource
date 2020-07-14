package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@GetMapping("/register")
	public void register() {
		log.info("레지스터 폼");
	}
	
	//글 등록하기
	@PostMapping("/register")
	public String registerPost(BoardVO vo,RedirectAttributes rttr) {
		log.info(""+vo);
		
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
	
	@PostMapping("/remove")
	public String delete(BoardVO vo,int bno,RedirectAttributes rttr,Criteria cri) {
		
		boolean del = service.delete(bno);
		
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
}
















