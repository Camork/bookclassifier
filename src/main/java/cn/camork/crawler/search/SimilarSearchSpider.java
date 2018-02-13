package cn.camork.crawler.search;

import com.alibaba.fastjson.JSONObject;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.JSONPath;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.annotation.RequestParameter;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.JsonBean;

import java.util.List;

/**
 * Created by Camork on 2018/2/13.
 */
@Gecco(matchUrl = "https://api.douban.com/v2/book/search?q={bookName}", pipelines = {"consolePipeline", "similarPipeline"})
public class SimilarSearchSpider implements JsonBean {

	@Request
	private HttpRequest request;

	@RequestParameter
	private String bookName;

	@JSONPath("$.books[0:2]")
	private List<JSONObject> books;

	public HttpRequest getRequest() {
		return request;
	}

	public void setRequest(HttpRequest request) {
		this.request = request;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public List<JSONObject> getBooks() {
		return books;
	}

	public void setBooks(List<JSONObject> books) {
		this.books = books;
	}
}