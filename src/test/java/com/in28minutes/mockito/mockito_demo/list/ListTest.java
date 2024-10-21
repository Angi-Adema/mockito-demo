package com.in28minutes.mockito.mockito_demo.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ListTest {

	@Test
	void simpleTest() {
		
		// Mock a simple method on the list interface. Be sure to hit CTRL + 1 to import static. We also made this a variable.
		List listMock = mock(List.class);
		
		// Mock a size method with a value of 3.
		when(listMock.size()).thenReturn(3);
		
		// Check if the above line is happening using assertEquals. Does not matter how many times you call this, will return the same value.
		assertEquals(3, listMock.size()); 
		assertEquals(3, listMock.size());
		assertEquals(3, listMock.size());
		assertEquals(3, listMock.size());
	}
	
	// Test more complex things.
	@Test
	void multipleReturns() {

		List listMock = mock(List.class);
		
		// Mock a size method first returning 1 and then 2.
		when(listMock.size()).thenReturn(1).thenReturn(2);
		
		// Check if the above line is happening using assertEquals for both returned values.
		assertEquals(1, listMock.size());
		assertEquals(2, listMock.size());  // This last value will be the default return value subsequent to that, will still be the last value and will still be returned even if three other statements of this were added.
	}
	
	// Sometimes you have to mock methods that have parameters passed in.
	@Test
	void specificParameters() {

		List listMock = mock(List.class);
		
		// When listMock.get(0) is called, we want to return a string back.
		when(listMock.get(0)).thenReturn("SomeString");
		
		// Check if the above line is happening using assertEquals for both returned values.
		assertEquals("SomeString", listMock.get(0));
		
		// Test with some values. String is an object so Mockito will return null back.
		assertEquals(null, listMock.get(1));
		
	}
	
	// What if you want to generically do something?
	// When we are setting values for our mock methods we want to be able to play with the parameters and configure the right return value based on the method name and the parameters.
	@Test
	void genericParameters() {

		List listMock = mock(List.class);
		
		// When listMock.get(0) is called, we want to return a string back.
		when(listMock.get(Mockito.anyInt())).thenReturn("SomeOtherString");
		
		// Check if the above line is happening using assertEquals for both returned values.
		assertEquals("SomeOtherString", listMock.get(0));
		
		// Test with some values. String is an object so Mockito will return null back.
		assertEquals("SomeOtherString", listMock.get(1));
		
	}
}
