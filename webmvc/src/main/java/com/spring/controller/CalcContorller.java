package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.domain.CalcVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/calc")
public class CalcContorller {

	@GetMapping("/calc")
	public void calcForm() {
		log.info("calc 폼 요청");
	}
	@PostMapping("/calc")
	public String calcPost(int num1,int num2,String op,Model model) {
		log.info("calc 요청");
		log.info("num1 "+num1);
		log.info("num2 "+num2);
		log.info("op "+op);
		
		int result=0;
		switch (op) {
		case "+":
			result = num1+num2;
			break;
		case "-":
			result = num1-num2;
			break;
		case "*":
			result = num1*num2;
			break;
		case "/":
			result = num1/num2;
			break;		
		}
		log.info("result = "+result);
		
		model.addAttribute("num1", num1);
		model.addAttribute("num2", num2);
		model.addAttribute("op", op);
		model.addAttribute("result", result);
		
		return "calc/calcresult";
	}

//		
//		//사용자가 보낸 값 가져오기
//		log.info("num1:"+vo.getNum1());
//		log.info("num2:"+vo.getNum2());
//		if(vo.getOp().equals("+")) {
//			log.info(""+(vo.getNum1()+vo.getNum2()));
//		}else if(vo.getOp().equals("-")) {
//			log.info(""+(vo.getNum1()+vo.getNum2()));
//		}else if(vo.getOp().equals("/")) {
//			log.info(""+(vo.getNum1()+vo.getNum2()));
//		}else if(vo.getOp().equals("*")) {
//			log.info(""+(vo.getNum1()+vo.getNum2()));
//		}
//	}

//	@PostMapping("/calc")
//	public String calcPost(@ModelAttribute("vo") CalcVO vo,Model model) { //도메인객체 쓰는게 좋아용 변수를 유지
//		log.info("calc 요청");
//		
//		int num1 = vo.getNum1();
//		int num2 = vo.getNum2();
//		String op = vo.getOp();
//		log.info("num1 "+num1);
//		log.info("num2 "+num2);
//		log.info("op "+op);
//		
//		int result=0;
//		switch (op) {
//		case "+":
//			result = num1+num2;
//			break;
//		case "-":
//			result = num1-num2;
//			break;
//		case "*":
//			result = num1*num2;
//			break;
//		case "/":
//			result = num1/num2;
//			break;		
//		}
//		log.info("result = "+result);
//		
//		//req.setAttribute 와 같은의미
//		model.addAttribute("result", result);
//		
//		return "calc/calcresult";
//	}
}



