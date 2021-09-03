package com.book.api.BookApplication.dao;

import java.util.List;

import com.book.api.BookApplication.VO.BooksVO;
import com.book.api.BookApplication.model.BooksLibrary;

public interface BooksDAO {
	
	   public void saveBooks(List<BooksLibrary> boksVO);
	   
	   public BooksLibrary getBooks(Long bookId);
	   
	   public List<BooksLibrary> fuzzySearch(String  title);
	

}
