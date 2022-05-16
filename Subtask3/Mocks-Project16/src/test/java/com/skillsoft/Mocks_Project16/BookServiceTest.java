package com.skillsoft.Mocks_Project16;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertNull;


@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

	@Mock
	private BookRepository bookRepositoryMock;
	
	@InjectMocks
	private BookService bookService;
	
	/*@Test
	public void testGetBooks() throws BookNotFoundException {
		
		when(bookRepositoryMock.getBook(anyString()))
		          .thenThrow(new BookNotFoundException("Book with this id was not found"));
		
		try {
			Book book = bookService.getBook("asd123");
			
			fail();
		} catch(Exception ex) {
			assertTrue(ex instanceof BookNotFoundException);
			assertEquals("Book with this id was not found", ex.getMessage());
			
		}
	}*/
	
	@Test
	public void testGetBooks1() throws BookNotFoundException {
		
		when(bookRepositoryMock.getBook(anyString()))
		          .thenThrow(new BookNotFoundException("Book with this id was not found"));
		
		assertNull(bookService.getBook("asd123"));
	
}
}
