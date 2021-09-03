package com.book.api.BookApplication.VO;

public class BooksVO {
	
	
	private Long bookID;
	private String title;
	private String authors;
	private Double average_rating;
	private String isbn;
	private String language_code;
	private Long ratings_count;
	private Long price;
	public Long getBookID() {
		return bookID;
	}
	public void setBookID(Long bookID) {
		this.bookID = bookID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthors() {
		return authors;
	}
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	public Double getAverage_rating() {
		return average_rating;
	}
	public void setAverage_rating(Double average_rating) {
		this.average_rating = average_rating;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getLanguage_code() {
		return language_code;
	}
	public void setLanguage_code(String language_code) {
		this.language_code = language_code;
	}
	public Long getRatings_count() {
		return ratings_count;
	}
	public void setRatings_count(Long ratings_count) {
		this.ratings_count = ratings_count;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "BooksVO [bookID=" + bookID + ", title=" + title + ", authors=" + authors + ", average_rating="
				+ average_rating + ", isbn=" + isbn + ", language_code=" + language_code + ", ratings_count="
				+ ratings_count + ", price=" + price + "]";
	}
	
	
	
	
	
	
	
	

}
