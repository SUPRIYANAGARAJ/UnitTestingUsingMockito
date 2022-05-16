package com.skillsoft.Mocks_Project22;

public class BookService {
	
	private BookRepository repository;
	
	public Book getBook(String id) {
		return repository.getBook(id);
	}
	
	public void addBook(Book book) {
		repository.addBook(book);
	}
	
	public void updateBook(Book book) {
		repository.updateBook(book);
	}
	
	public void deleteBook(String id) {
		repository.deleteBook(id);
	}

}
