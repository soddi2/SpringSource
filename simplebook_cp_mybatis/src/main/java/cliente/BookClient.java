package cliente;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.BookVO;
import com.spring.service.BookService;

public class BookClient {
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		BookService service = (BookService) ctx.getBean("book");
		
		
		//등록
		BookVO vo = new BookVO();
//		vo.setCode("9998");
//		vo.setTitle("백기사");
//		vo.setWriter("안나와");
//		vo.setPrice(5757);
//		if(service.intsert(vo)) {
//			System.out.println("성공");
//		}else {
//			System.out.println("실패");
//		}
		
		//수정
//		vo.setCode("9999");
//		vo.setPrice(22222);
//		if(service.update(vo)) {
//			System.out.println("성공");
//		}else {
//			System.out.println("실패");
//		}
		
		//삭제
//		service.delete("9999");
		
		//하나만 불러와
		vo = service.getBook("1001");
		System.out.println(vo);

//		List<BookVO> list = service.getList();
//		for(BookVO vo1:list) {
//			System.out.println(vo1);
//		}
	}
}










