package com.in28minutes.mockito.mockito_demo.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

//Refactored class name from SomeBusinessImplTest.
class SomeBusinessImplStubTest {

	@Test
	void findTheGreatestFromAllData_basicScenario() {
		// fail("Not
		// Here we create an instance of SomeBusinessImple using an instance of the
		// DataService Stub.
		DataService dataServiceStub = new DataServiceStub1();

		// Pass in dataServiceStub to make use of the stub instead of talking to
		// DataService.
		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceStub);

		// After we test this with the lines above and confirm it passes, we assign the
		// below to a local variable.
		// businessImpl.findTheGreatestFromAllData();

		int result = businessImpl.findTheGreatestFromAllData();
		assertEquals(25, result);
	}


	@Test
	void findTheGreatestFromAllData_withOneValue() {

		DataService dataServiceStub = new DataServiceStub2();

		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceStub);

		int result = businessImpl.findTheGreatestFromAllData();
		assertEquals(35, result);
	}

}

// Create a Stub for the dataservice (replaced DataService with a stub of DataService). Instead of testing the DataService, we are creating a Stub class which is an example class that we will make use of.
// Testing a lot of scenarios is difficult with stubs as you have to create a new class again and again for each step. Here we refactor the code to include multiple scenarios. See multiple tests above too.
class DataServiceStub1 implements DataService {

	@Override
	public int[] retrieveAllData() {
		// TODO Auto-generated method stub
		return new int[] { 25, 15, 5 };
	}

}

class DataServiceStub2 implements DataService {

	@Override
	public int[] retrieveAllData() {
		// TODO Auto-generated method stub
		return new int[] { 35 };
	}

}
