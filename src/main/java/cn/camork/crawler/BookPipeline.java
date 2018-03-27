package cn.camork.crawler;

import cn.camork.core.CoreUtils;
import cn.camork.service.BookService;
import com.geccocrawler.gecco.pipeline.Pipeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Camork on 2017-05-12.
 * BookPipeline
 */

@Service("bookPipeline")
public class BookPipeline implements Pipeline<Book> {

	private BookService bookService;

	@Autowired
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	@Override
	public void process(Book bean) {

		Object[] data = CoreUtils.getDateAndPrice(new String[]{bean.getTempDate(), bean.getTempPrice()});

		bean.setAddDate(new Date());
		bean.setPubDate((Date) data[0]);
		bean.setBookPrice((Float) data[1]);
		bean.setBookDescribe(bean.getBookDescribe().replace("\n", "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"));

		bookService.insertBook(bean);
	}
}
