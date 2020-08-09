package com.in28minutes;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

public class ListTest {
	
	@Test
	public void letsMockListSizeMethod() {
		List listMock=mock(List.class);
	    when(listMock.size()).thenReturn(2);
	    assertEquals(2, listMock.size());
	}

	@Test
	public void letsMockListSize_ReturnMultipleVales() {
		List listMock=mock(List.class);
	    when(listMock.size()).thenReturn(2).thenReturn(3);
	    assertEquals(2, listMock.size());
	    assertEquals(3, listMock.size());
	}
	
	@Test
	public void letsMockGetMethod() {
		List listMock=mock(List.class);
	    when(listMock.get(0)).thenReturn("Roopa");
	    assertEquals("Roopa", listMock.get(0));
	   // not mock the get(1) nice mocks kick in it would return a value null
	    assertEquals(null,listMock.get(1));
	}
	
	@Test
	public void letsMockGetMethod_ReturnsNull() {
		List listMock=mock(List.class);
	    //when(listMock.get(0)).thenReturn("Roopa");
	    assertEquals(null, listMock.get(0));
	   // not mock the get(1) nice mocks kick in it would return a value null
	    assertEquals(null,listMock.get(1));
	}
	
	@Test
	public void letsMockGetMethod_Argumentmather() {
		List listMock=mock(List.class);
	    when(listMock.get(anyInt())).thenReturn("in28minutes").thenReturn("Malemath");
	    assertEquals("in28minutes", listMock.get(0));
	   // not mock the get(1) nice mocks kick in it would return a value null
	    assertEquals("Malemath",listMock.get(1));
	}
	
	@Test(expected=RuntimeException.class) // catching exception
	public void letsMockGetMethod_ExceptionHangling() {
		List listMock=mock(List.class);
	    when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something"));
	    listMock.get(1);
	   
	}
}
