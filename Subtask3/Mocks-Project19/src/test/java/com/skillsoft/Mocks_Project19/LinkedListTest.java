package com.skillsoft.Mocks_Project19;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.MockitoAnnotations.openMocks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;
import static org.mockito.Mockito.*;

public class LinkedListTest {

	@Spy
	LinkedList<String> linkedListSpy = new LinkedList<>();
	
	AutoCloseable closeable;
	
	@BeforeEach
	public void setupTests() {
		closeable = openMocks(this);
	}
	
	@AfterEach
	public void tearDownTests() throws Exception {
		closeable.close();
	}
	
	@Test
	public void testLinkedList() {
		
		linkedListSpy.add("Nora");
		linkedListSpy.add("Fred");
		linkedListSpy.add("Maureen");
		linkedListSpy.add("Ophelia");
		
		verify(linkedListSpy, times(4)).add(anyString());
		
		assertEquals(4, linkedListSpy.size());
		assertEquals("Nora", linkedListSpy.get(0));
		
		linkedListSpy.remove("Maureen");
		
		verify(linkedListSpy).get(0);
		verify(linkedListSpy).remove("Maureen");
		
		
	}
	
	@Test
	public void testLinkedList1() {
		
		linkedListSpy.add("Nora");
		linkedListSpy.add("Fred");
		linkedListSpy.add("Maureen");
		linkedListSpy.add("Ophelia");
		
		verify(linkedListSpy, times(4)).add(anyString());
		
		assertEquals(4, linkedListSpy.size());
		when(linkedListSpy.size()).thenReturn(1001);
		
		assertEquals(1001, linkedListSpy.size());
		
		
	}
	
	@Test
	public void testLinkedList2() {
		
		linkedListSpy.add("Nora");
		linkedListSpy.add("Fred");
		linkedListSpy.add("Maureen");
		linkedListSpy.add("Ophelia");
		
		verify(linkedListSpy, times(4)).add(anyString());
		
		assertEquals(4, linkedListSpy.size());
		when(linkedListSpy.size()).thenReturn(1001);
		
		assertEquals(1001, linkedListSpy.size());
		
		linkedListSpy.remove("Maureen");
		
		assertEquals(1001, linkedListSpy.size());
		
		
	}
	
	@Test
	public void testLinkedList3() {
		
		linkedListSpy.add("Nora");
		linkedListSpy.add("Fred");
		linkedListSpy.add("Maureen");
		linkedListSpy.add("Ophelia");
		
		verify(linkedListSpy, times(4)).add(anyString());
		
		assertEquals(4, linkedListSpy.size());
		when(linkedListSpy.remove(anyString())).thenReturn(true);
		
		linkedListSpy.remove("Nora");
		linkedListSpy.remove("Ophelia");
		
		verify(linkedListSpy, times(2)).remove(anyString());
		
		assertEquals(4, linkedListSpy.size());
		
		
	}
	
	
}
