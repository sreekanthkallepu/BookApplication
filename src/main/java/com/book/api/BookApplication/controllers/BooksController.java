package com.book.api.BookApplication.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.book.api.BookApplication.VO.BooksVO;
import com.book.api.BookApplication.dao.BooksDAO;
import com.book.api.BookApplication.model.BooksLibrary;
import com.book.api.BookApplication.service.BooksService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class BooksController {
	
	@Autowired
	RestTemplate restTeplate;
	@Autowired
	BooksService booksService;

	@GetMapping("/fetchBooks")
	public void fetchBooksAndSaveDataBse() {
		
		List<BooksLibrary> booksVO = new ArrayList<BooksLibrary>();
		
//		
//		BooksLibrary booksibrary = new BooksLibrary();
//		booksibrary.setBookId((long) 40139);
//		booksibrary.setTitle("Gone Bamboo");
//		booksibrary.setAuthors("Anthony Bourdain");
//		booksibrary.setAvarageRating(3.47);
//		booksibrary.setIsbn("1841953679");
//		booksibrary.setLanguageCode("eng");
//		booksibrary.setRatingsConut((long) 1021);
//		booksibrary.setPrice((long) 2105);
		
		
//		booksVO.add(booksibrary);
		
		//booksDAO.saveBooks(booksVO);
		BooksLibrary books = booksService.getBooks((long) 40139);
		System.out.println(books.getTitle());
		
	}
	
	@GetMapping("/search")
	public void fuzzySearch(@RequestParam("title") String title) {
		
	
	
	List<BooksLibrary> fuzzySearchResultList = booksService.fuzzySearch(title);
	
  if(fuzzySearchResultList != null  && !fuzzySearchResultList.isEmpty() && fuzzySearchResultList.size()>=1) {
	  fuzzySearchResultList.stream().forEach(System.out::println);
  }
		
	}
	
	
	@GetMapping("/")
	public ResponseEntity<?> fetAPIResultAndSave() throws JsonProcessingException {
		
	
	System.out.println("inside fetch  api");
	
	List<HashMap<String, String>> booksList = restTeplate.getForObject("https://s3-ap-southeast-1.amazonaws.com/he-public-data/books8f8fe52.json", List.class);
	
	
	booksService.saveBooks(booksList);
	
	return new ResponseEntity<>(booksList, HttpStatus.OK);
		
	}
	
//	@GetMapping("/")
//	public void fetAPIResultandsave(@PathVariable String title) {
//		
//	
//	System.out.println("inside fetch  api"+title);
//		
//		
//	}
	
	
	@GetMapping("/{bookId}")
	public ResponseEntity<?> getBookById(@PathVariable Long bookId) {
		
		return new ResponseEntity<>(booksService.getBooks(bookId), HttpStatus.OK);

	
		
		
	}
	
	@GetMapping("/search/{title}")
	public ResponseEntity<?> getBookById(@PathVariable String title) {
		
	
		return new ResponseEntity<>(booksService.fuzzySearch(title), HttpStatus.OK);
		
		
	}
	
}
