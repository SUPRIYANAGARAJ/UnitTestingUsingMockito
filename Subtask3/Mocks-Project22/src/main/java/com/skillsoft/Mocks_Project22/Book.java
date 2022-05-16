package com.skillsoft.Mocks_Project22;

import java.util.Objects;

public class Book {

	private String id;
	private String name;
	private String authorName;
	
	public Book(String id, String name, String authorName) {
		super();
		this.id = id;
		this.name = name;
		this.authorName = authorName;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id,name,authorName);
	}
	
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		
		Book book = (Book) o;
		
		return id.equals(book.id) &&
				name.equals(book.name) &&
				authorName.equals(book.authorName);
	}
}
