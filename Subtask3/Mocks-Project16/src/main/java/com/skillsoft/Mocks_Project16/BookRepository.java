package com.skillsoft.Mocks_Project16;

import java.util.List;


public interface BookRepository {
	
   Book getBook(String id) throws BookNotFoundException;
	
	
	List<Book> getBooks(String query);
	
	void addBook(Book book);
	
	void updateBook(Book book);

	void deleteBook(String id);
	

}
