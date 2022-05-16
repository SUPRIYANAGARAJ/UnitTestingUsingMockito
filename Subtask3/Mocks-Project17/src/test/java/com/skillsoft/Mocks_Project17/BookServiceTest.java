package com.skillsoft.Mocks_Project17;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doThrow;

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
	
	@Test
	public void testDeleteBook() throws BookNotFoundException {
		
		/*doThrow(new BookNotFoundException("Book with this id was not found"))
		.when(bookRepositoryMock)
		.deleteBook(anyString());
		
		try {
			 bookService.deleteBook("asd123");
			
			fail();
		} catch(Exception ex) {
			assertTrue(ex instanceof BookNotFoundException);
			assertEquals("Book with this id was not found", ex.getMessage());
			
		}
	}*/
	
	doThrow( BookNotFoundException.class)
	.when(bookRepositoryMock)
	.deleteBook(anyString());
	
	try {
		 bookService.deleteBook("asd123");
		
		fail();
	} catch(Exception ex) {
		assertTrue(ex instanceof BookNotFoundException);
		
		
	}
}
}
