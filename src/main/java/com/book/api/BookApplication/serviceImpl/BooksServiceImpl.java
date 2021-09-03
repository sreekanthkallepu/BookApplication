package com.book.api.BookApplication.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.api.BookApplication.dao.BooksDAO;
import com.book.api.BookApplication.model.BooksLibrary;
import com.book.api.BookApplication.service.BooksService;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class BooksServiceImpl implements BooksService{
    @Autowired
	BooksDAO booksDAO;

	@Override
	public void saveBooks(List<HashMap<String, String>> boksVOMapList) {
		try {
		List<BooksLibrary> bookLibraryList = new ArrayList<BooksLibrary>();
		for(HashMap<String, String> map:boksVOMapList) {
			String json = new ObjectMapper().writeValueAsString(map);
			ObjectMapper mapper = new ObjectMapper();
			BooksLibrary bookLibrary = mapper.readValue(json, BooksLibrary.class);
			bookLibraryList.add(bookLibrary);
		}
		
		booksDAO.saveBooks(bookLibraryList);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public BooksLibrary getBooks(Long bookId) {
		return booksDAO.getBooks(bookId);
	}

	@Override
	public List<BooksLibrary> fuzzySearch(String title) {
		return booksDAO.fuzzySearch(title);
	}

}
