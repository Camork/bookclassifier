package cn.camork.mapper;

import cn.camork.crawler.Book;
import cn.camork.model.BookType;

import java.util.List;

/**
 * Created by Camork on 2017-05-05.
 * BookMapper
 */
public interface BookMapper {

	int insertBookType(BookType bookType);

	int insertBook(Book book);

	List<Book> getHotBooks();

	List<BookType> getBookTypes();

	List<Book> getBooksByType(String typeName);

}
