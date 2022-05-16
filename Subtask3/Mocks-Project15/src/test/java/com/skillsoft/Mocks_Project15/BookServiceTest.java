package com.skillsoft.Mocks_Project15;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
	
	@Mock
	private BookRepository bookRepositoryMock;
	
	@InjectMocks
	private BookService bookService;
	
	@Test
	public void testGetBooks() {
		
		when(bookRepositoryMock.getBook(anyString()))
		          .thenThrow(new IllegalArgumentException("Wrongly formed id"));
		
		try {
			Book book = bookService.getBook("asd123");
			
			fail();
		} catch(Exception ex) {
			assertTrue(ex instanceof IllegalArgumentException);
			assertEquals("Wrongly formed id", ex.getMessage());
			
		}
	}
	
	

}
