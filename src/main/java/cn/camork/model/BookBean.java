package cn.camork.model;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by camork on 27/02/2018.
 */
public class BookBean {

	private String origin_title;
	private String summary;
	private String image;
	private Map<String,String> images;
	private List<String> author;
	private String catalog;
	private List<String> translator;
	private Map<String,String> rating;
	private String alt;
	private String binding;
	private String title;
	private String url;
	private List<Map<String,String>> tags;
	private String alt_title;
	private String author_intro;
	private String pages;
	private String price;
	private String subtitle;
	private String isbn13;
	private String publisher;
	private String isbn10;
	private String id;
	private String pubdate;

	public String getOrigin_title() {
		return origin_title;
	}

	public void setOrigin_title(String origin_title) {
		this.origin_title = origin_title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Map<String, String> getImages() {
		return images;
	}

	public void setImages(Map<String, String> images) {
		this.images = images;
	}

	public List<String> getAuthor() {
		return author;
	}

	public void setAuthor(List<String> author) {
		this.author = author;
	}

	public String getCatalog() {
		return catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	public List<String> getTranslator() {
		return translator;
	}

	public void setTranslator(List<String> translator) {
		this.translator = translator;
	}

	public Map<String, String> getRating() {
		return rating;
	}

	public void setRating(Map<String, String> rating) {
		this.rating = rating;
	}

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	public String getBinding() {
		return binding;
	}

	public void setBinding(String binding) {
		this.binding = binding;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Map<String, String>> getTags() {
		return tags;
	}

	public void setTags(List<Map<String, String>> tags) {
		this.tags = tags;
	}

	public String getAlt_title() {
		return alt_title;
	}

	public void setAlt_title(String alt_title) {
		this.alt_title = alt_title;
	}

	public String getAuthor_intro() {
		return author_intro;
	}

	public void setAuthor_intro(String author_intro) {
		this.author_intro = author_intro;
	}

	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getIsbn13() {
		return isbn13;
	}

	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getIsbn10() {
		return isbn10;
	}

	public void setIsbn10(String isbn10) {
		this.isbn10 = isbn10;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPubdate() {
		return pubdate;
	}

	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BookBean bookBean = (BookBean) o;
		return Objects.equals(image, bookBean.image);
	}

	@Override
	public String toString() {
		return "title='" + title + '\'' +
				", image='" + image + '\'';
	}

	@Override
	public int hashCode() {
		return Objects.hash(image, title);
	}

	public boolean isEmpty(){
		if(title==null && image==null){
			return true;
		}

		return false;
	}
}
