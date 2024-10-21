package com.in28minutes.mockito.mockito_demo.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

//Refactored class name from SomeBusinessImplTest.
class SomeBusinessImplMockTest {

	@Test
	void findTheGreatestFromAllData_basicScenario() {
		// fail("Not
		// How do we create a mock for the DataService? Mockito provides simple methods to create the mocks. Pass in an interface or a class to the mock method.
		// CTRL + 1 to bring in static imports above. Creating a mock for this class. Hold CTRL + 1 again to assign to a variable.
		DataService dataServiceMock = mock(DataService.class);
		
		// No longer need the line below as we can just make use of the mock.
		//DataService dataServiceStub = new DataServiceStub1();
		
		// Once we create a mock, we must tell it to return a value (will get a NullPointerException). We want to return the same data that the stub returned.
		// Need to tell our dataServiceMock that when retrieveAllData method is called, return an array with these values back. 
		//dataServiceMock.retrieveAllData() => new int[] { 25, 15, 5 }
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 25, 15, 5 });

		// Pass in dataServiceStub to make use of the stub instead of talking to DataService. To use the mock, we pass in dataServiceMock instead.
		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);

		// After we test this with the lines above and confirm it passes, we assign the below to a local variable.
		// businessImpl.findTheGreatestFromAllData();

		// Move the below line to inline with the assertEquals.
		//int result = businessImpl.findTheGreatestFromAllData();
		assertEquals(25, businessImpl.findTheGreatestFromAllData());
	}
	
	@Test
	void findTheGreatestFromAllData_OneValue() {

		DataService dataServiceMock = mock(DataService.class);

		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 35 });

		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);

		assertEquals(35, businessImpl.findTheGreatestFromAllData());
	}

}

// If we want to create a new scenario, all we need to do is write a new test. We do not have to write a number of stub classes too. Simpler and easier to write the tests.


