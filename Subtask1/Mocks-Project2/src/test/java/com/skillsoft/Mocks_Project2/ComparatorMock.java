package com.skillsoft.Mocks_Project2;

import java.util.Comparator;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ComparatorMock {
	
	@Test
	public void mockComparator() {
		
		Comparator<String> comparatorMock = mock(Comparator.class);
		
		System.out.println("toString() of Comparator: " + comparatorMock);
		System.out.println("getClass() of Comparator: " + comparatorMock.getClass());
		System.out.println("comparatorMock instanceof Comparator: " + (comparatorMock instanceof Comparator));
	}
	
	@Test
	public void mockComparator1() {
		
		Comparator<String> comparatorMock = mock(Comparator.class);
		
		when(comparatorMock.compare("Alice", "Bob")).thenReturn(1);
		when(comparatorMock.compare("Bob", "Charles")).thenReturn(1);
		when(comparatorMock.compare("Alice", "Charles")).thenReturn(1);
		
		when(comparatorMock.compare("Bob", "Alice")).thenReturn(-1);
		when(comparatorMock.compare("Charles", "Bob")).thenReturn(-1);
		when(comparatorMock.compare("Charles", "Alice")).thenReturn(-1);
		
		when(comparatorMock.compare("Alice", "Alice")).thenReturn(0);
		when(comparatorMock.compare("Bob", "Bob")).thenReturn(0);
		when(comparatorMock.compare("Charles", "Charles")).thenReturn(0);
		
		assertTrue(comparatorMock.compare("Alice", "Charles") > 0);
		assertTrue(comparatorMock.compare("Charles", "Bob") < 0);
		assertEquals(0,comparatorMock.compare("Bob", "Bob"));
	}

}
