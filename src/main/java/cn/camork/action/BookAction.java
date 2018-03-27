package cn.camork.action;

import cn.camork.core.CoreUtils;
import cn.camork.crawler.Book;
import cn.camork.model.BookBean;
import cn.camork.model.BookType;
import cn.camork.service.BookService;
import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.pipeline.PipelineFactory;
import com.geccocrawler.gecco.request.HttpGetRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created by Camork on 2017-05-13.
 */
@Controller
@RequestMapping("/book")
public class BookAction {

	@Autowired
	private PipelineFactory springPipelineFactory;

	@Autowired
	private BookService bookService;

	@RequestMapping("/category")
	public String getCategory(Map<String, Map<String, List<BookType>>> m) {

		Map<String, List<BookType>> categories = new HashMap<>();
		List<BookType> lists = bookService.getBookTypes();

		List<BookType> data = new ArrayList<>();
		for (BookType bookType : lists) {

			String title = bookType.getTypeTitle();

			if (categories.get(title) == null) {
				data = new ArrayList<>();
				data.add(bookType);

				categories.put(title, data);
			}
			else {
				categories.get(title).add(bookType);
			}
		}
		m.put("categories", categories);

		return "page/category";
	}

	@RequestMapping("/type/{typeName}")
	public String tag(@PathVariable String typeName, Map<String, List<Book>> m, Model model) {
		model.addAttribute("typeName", typeName);
		if (bookService.getBooksByType(typeName).isEmpty()) {

			HttpGetRequest start = new HttpGetRequest("https://book.douban.com/tag/" + typeName);
			GeccoEngine.create()
					.classpath("cn.camork.crawler")
					.pipelineFactory(springPipelineFactory)
					.start(start)
					.run();
		}

		List<Book> lists = bookService.getBooksByType(typeName);
		m.put("lists", lists);
		return "page/typeList";
	}

	@RequestMapping("/addBook")
	@ResponseBody
	public Map<String, String> addBook(String id) {
		Map<String, String> m = new HashMap<>();
		for (BookBean bean : CoreUtils.bookList) {
			if (bean.getId().equals(id)) {
				Book book = new Book();
				Object[] data = CoreUtils.getDateAndPrice(new String[]{bean.getPubdate(), bean.getPrice()});

				book.setAddDate(new Date());
				book.setPubDate((Date) data[0]);
				book.setBookPrice((Float) data[1]);
				book.setBookDescribe(bean.getSummary());
				book.setBookAuthor(bean.getAuthor().get(0));
				book.setPublisher(bean.getPublisher());
				book.setBookId(Integer.parseInt(bean.getId()));
				book.setBookName(bean.getTitle());
				book.setBookPic(bean.getImages().get("large"));

				BookType[] existedTypes = bookService.getBookTypes().toArray(new BookType[0]);

				String[] tagArray = bean.getTags().stream().map(
						item -> item.get("name")
				).toArray(
						String[]::new
				);

				String typeName = null;

				for (String tag : tagArray) {
					for (BookType existedTag : existedTypes) {
						if (tag.equals(existedTag.getTypeName())) {
							typeName = existedTag.getTypeName();
							break;
						}
					}
				}
				if (typeName == null) {
					typeName = "book.douban.com";
				}

				book.setTypeName(typeName);

				bookService.insertBook(book);

				if (typeName.equals("book.douban.com")) {
					typeName = "首页";
				}

				m.put("msg", "成功添加到" + typeName + "目录");
				return m;
			}
		}
		m.put("msg", "添加失败");
		return m;
	}

}
