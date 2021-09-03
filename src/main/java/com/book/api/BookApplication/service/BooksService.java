package com.book.api.BookApplication.service;

import java.util.HashMap;
import java.util.List;

import com.book.api.BookApplication.model.BooksLibrary;

public interface BooksService {
	
	public void saveBooks(List<HashMap<String, String>> boksVO);
	   
	   public BooksLibrary getBooks(Long bookId);
	   
	   public List<BooksLibrary> fuzzySearch(String  title);

}
