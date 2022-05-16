package com.skillsoft.Mocks_Project18;

import org.junit.jupiter.api.Test;


import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import static org.mockito.Mockito.*;

public class LinkedListTest {
	
	@Test
	public void testLinkedList() {
		 
		LinkedList<String> linkedList = new LinkedList<>();
		LinkedList<String> linkedListSpy = spy(linkedList);
		
		System.out.println("toString() on spy: " + linkedListSpy);
		
		System.out.println("getClass() on spy: " + linkedListSpy.getClass());
		
		System.out.println("linkedListSpy instanceof LinkedList: " +(linkedListSpy instanceof LinkedList));
		
	}
	
	@Test
	public void testLinkedList1() {
		 
		LinkedList<String> linkedList = new LinkedList<>();
		LinkedList<String> linkedListSpy = spy(linkedList);
		
		linkedListSpy.add("Nora");
		linkedListSpy.add("Fred");
		linkedListSpy.add("Maureen");
		
		verify(linkedListSpy, times(3)).add(anyString());
		
		assertEquals(3, linkedListSpy.size());
	}

	@Test
	public void testLinkedList2() {
		 
		LinkedList<String> linkedList = new LinkedList<>();
		LinkedList<String> linkedListSpy = spy(linkedList);
		
		linkedListSpy.add("Nora");
		linkedListSpy.add("Fred");
		linkedListSpy.add("Maureen");
		
		System.out.println("Contents of linked list: " + linkedList);
		System.out.println("Contents of linked list spy: " + linkedListSpy);
		
		assertNotEquals(linkedList.size(),linkedListSpy.size());
	}

}
