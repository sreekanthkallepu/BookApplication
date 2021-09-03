package com.book.api.BookApplication.daoImpl;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.book.api.BookApplication.VO.BooksVO;
import com.book.api.BookApplication.dao.BooksDAO;
import com.book.api.BookApplication.model.BooksLibrary;
@Repository
public class BooksDAOImpl implements BooksDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	

	@Override
	public void saveBooks(List<BooksLibrary> boksVOList) {
		
		Session session = null;
				try {
					session = 	sessionFactory.openSession();
					Transaction beginTransaction = session.beginTransaction();
					for(BooksLibrary bookVO:boksVOList) {
						session.save(bookVO);

					}
					beginTransaction.commit();
				}catch(Exception e) {
					e.printStackTrace();
					
					
				}finally {
					session.close();
				}
		
		
	}



	@SuppressWarnings("deprecation")
	@Override
	public BooksLibrary getBooks(Long bookID) {
		BooksLibrary booksLibrary = null;
		Session session = null;
				try {
					session = 	sessionFactory.openSession();
					Transaction beginTransaction = session.beginTransaction();
					String hqlQuery="FROM BooksLibrary as book where book.bookID = :bookID";
					Query query=session.createQuery(hqlQuery);
					

					query.setLong("bookID", bookID);
					booksLibrary = (BooksLibrary) query.uniqueResult();
					 beginTransaction.commit();
					 
					 
				}catch(Exception e) {
					e.printStackTrace();
					
					
				}finally {
					session.close();
				}
		
		return booksLibrary;
	}



	@Override
	public List<BooksLibrary> fuzzySearch(String title) {
		List<BooksLibrary> booksLibraryList = new LinkedList<BooksLibrary>();
		Session session = null;
				try {
					session = 	sessionFactory.openSession();
					Transaction beginTransaction = session.beginTransaction();
					
					Criteria queryLike = session.createCriteria(BooksLibrary.class);
					queryLike.add(Restrictions.like("title", title, MatchMode.ANYWHERE));
					List list = queryLike.list();
					if(list != null && !list.isEmpty() && list.size()>=1) {
						
						for(Object obj:list) {
							booksLibraryList.add((BooksLibrary)obj);
						}
					}

					
					 beginTransaction.commit();
					 
					 
				}catch(Exception e) {
					e.printStackTrace();
					
					
				}finally {
					session.close();
				}
		
		return booksLibraryList;
	}

}
