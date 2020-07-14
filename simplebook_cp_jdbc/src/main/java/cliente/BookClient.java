package cliente;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.service.BookService;

import domain.BookVO;

public class BookClient {
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		BookService service = (BookService) ctx.getBean("book");
		
		
		//등록
//		BookVO vo = new BookVO();
//		vo.setCode("1112");
//		vo.setTitle("유유바바");
//		vo.setWriter("안영덕");
//		vo.setPrice(20000);
//		boolean result=service.intsert(vo);
//		if(result == false) {
//			System.out.println("입력성공");
//		}else {
//			System.out.println("입력실패");
//		}

		//책 목록
//		List<BookVO> list = service.getList();
//		for(BookVO vo:list) {
//			System.out.println(vo);
//		}
		
		//게시글 수정
		BookVO vo = new BookVO();
		vo.setCode("1010");
		vo.setTitle("수정이 안됨");
		vo.setWriter("김시성");
		vo.setPrice(300);
		boolean result = service.update(vo);
		if(result == false) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
	
		
		//게시글 삭제
//		boolean vo = service.delete("1111");
//		if(vo == false) {
//			System.out.println("성공");
//		}else {
//			System.out.println("실패");
//		}
		
		//게시글 하나 가져오기
//		BookVO vo = service.getBook("1002");
//		System.out.println(vo);
	}	
}















