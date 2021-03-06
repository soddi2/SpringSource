package com.spring.controller;

import java.io.Reader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.BookVO;
import com.spring.service.BookService;


import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.proxy.annotation.Post;

@Slf4j
@Controller
//@RequestMapping("/book/*") //book으로 들어오는 모든 요청 처리
public class BookController {

	@Autowired
	private BookService service;

	//주소창에 직접 들어오게 되면 tab(실패하면 다시 되돌아가게)을 걸어 놓았기 때문에 405에러가 뜸 그래서 딴데로 가게 처리
	@GetMapping(value= {"/insert","/delete","/modify"})
	public String handleGet() {
		log.info("부적절한 요청");
		return "redirect:/";
	}
	
	//도서목록보기 클릭 시 동작하는 컨트롤러 생성 
	//어떤 요청에 대응 
	@GetMapping("/select") // 주소창 경로
	public String select(Model model) {
		log.info("보기 페이지 동작");

		//전체 도서목록을 가져온 후 모델에 담고
		List<BookVO> list = service.BookSelect();
		model.addAttribute("list", list);
		

		// /WEB-INF/views/ XXX
		return "book_selectAll"; //주소 이름이 다른경우
	}
	
	//입력
	@PostMapping("/insert") //post맵핑은 변화를 줘야할떄 쓰고 get맵핑은 바로가기 기능
	public String insertPost(BookVO vo,RedirectAttributes rttr) {
		log.info(""+vo);
		
		try { //에러를 확인하고 에러시 페이지 이동이 될 수 있게 해주기
			boolean insert = service.insert(vo); //이 친구도 트라이문에 같이 들어야와 예외처리 가능
			if(insert) {
				return "redirect:/select"; //jsp를 띄우는게 아니고 DB를까지 데려와야 하기 때문에 list를 불러 와야함
			}else {
				rttr.addFlashAttribute("tab", "insert");
				return "redirect:/"; //실패하면 나는 처음으로 가겠다
			}
			
		} catch (Exception e) {
			rttr.addFlashAttribute("tab", "insert");
			return "redirect:/"; //에러시 첫 화면으로 넘어가기
		}
		
		//return "redirect:/book_insert"; //URL 주소를 다시 요청하는것
	}

	//삭제
	@PostMapping("/delete")
	public String deletepost(String code,RedirectAttributes rttr) {
		log.info(""+code);
		
		boolean delete = service.delete(code);
		
		if(delete) {
			return "redirect:/select";
		}
		rttr.addFlashAttribute("tab", "delete");
		return "redirect:/";
	}
	
	
	//수정
	@PostMapping("/modify")
	public String modify(String code,int price,RedirectAttributes rttr) {
		log.info(""+code);
		log.info(""+price);
		
		boolean modify = service.modify(code, price);
		
		if(modify) {
			return "redirect:/select";
		}
		
		rttr.addFlashAttribute("tab", "modify");
		return "redirect:/";
	}
	
//	@GetMapping("/search")
//	public String getList() {
//		return "redirect:book_searchAll";
//	}
	
	//검색
	@PostMapping("/search")
	public String getListPost(String criteria,String keyword,Model model,RedirectAttributes rttr) {
		log.info("검색요청"+criteria+"검색어 : "+keyword);
		
		//전체 도서목록을 가져온 후 모델에 담고
		List<BookVO> list = service.getList(criteria, keyword);
		if(!list.isEmpty()) {			
			model.addAttribute("list", list);
			
			return "book_searchAll";
		}else {
			rttr.addFlashAttribute("msg","검색결과없음");
			rttr.addFlashAttribute("tab","search");
			return "redirect:/";
		}
	}
	
	//서취에 대한 get방식
	@GetMapping("/search")
	public String getList(RedirectAttributes rttr) {
		
		rttr.addFlashAttribute("tab","search");
		return "redirect:/";
	}
}





























