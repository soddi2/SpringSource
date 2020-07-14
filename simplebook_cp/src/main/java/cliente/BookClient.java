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
		
		List<BookVO> list = service.getList();
		for(BookVO vo:list) {
			System.out.println(vo);
		}
		
	}
}
