package cn.camork.crawler;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.JSONPath;
import com.geccocrawler.gecco.annotation.RequestParameter;
import com.geccocrawler.gecco.spider.JsonBean;
import com.wuwenze.poi.annotation.ExportConfig;

import java.util.Date;

/**
 * Created by Camork on 2017-05-11.
 * book detail Json info
 */

@Gecco(matchUrl = "https://api.douban.com/v2/book/{bookId}?bookType={typeName}", pipelines = {"consolePipeline", "bookPipeline"})
public class Book implements JsonBean {

	@ExportConfig(value = "id",width = 80)
	@RequestParameter
	private int bookId;

	@RequestParameter
	private String typeName;

	@ExportConfig(value = "名称",width = 300)
	@JSONPath("$.title")
	private String bookName;

	@ExportConfig(value = "价格",width = 50)
	private Float bookPrice;

	@JSONPath("$.price")
	private String tempPrice;

	@ExportConfig(value = "作者",width = 150)
	@JSONPath("$.author[0]")
	private String bookAuthor;

	@ExportConfig(value = "出版社",width = 200)
	@JSONPath("$.publisher")
	private String publisher;

	@JSONPath("$.images.large")
	private String bookPic;

	@JSONPath("$.pubdate")
	private String tempDate;

	private Date addDate;

	@ExportConfig(value = "出版日期",width = 250)
	private Date pubDate;

	@ExportConfig("描述")
	@JSONPath("$.summary")
	private String bookDescribe;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Float getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(Float bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getTempPrice() {
		return tempPrice;
	}

	public void setTempPrice(String tempPrice) {
		this.tempPrice = tempPrice;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getBookPic() {
		return bookPic;
	}

	public void setBookPic(String bookPic) {
		this.bookPic = bookPic;
	}

	public String getTempDate() {
		return tempDate;
	}

	public void setTempDate(String tempDate) {
		this.tempDate = tempDate;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	public String getBookDescribe() {
		return bookDescribe;
	}

	public void setBookDescribe(String bookDescribe) {
		this.bookDescribe = bookDescribe;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
}
