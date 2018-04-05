package cn.camork.action;

import cn.camork.crawler.Book;
import cn.camork.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * Created by Camork on 2017-04-28.
 * Index class
 */

@Controller
public class Index {

	@Autowired
	private BookService bookService;

	@RequestMapping("/index")
	public String index(Map<String, List<Book>> m) {
		List<Book> hotBooks = bookService.getHotBooks();
		m.put("hotBooks", hotBooks);
		return "home";
	}

}
