package com.skillsoft.Mocks_Project22;

public interface BookRepository {
	
	Book getBook(String id);
	
	void addBook(Book book);
	
	void updateBook(Book book);
	
	void deleteBook(String id);

}
