package com.in28minutes.mockito.mockito_demo.business;

public class SomeBusinessImpl {
	
	// This is a common pattern in dependency injection, where external dependencies are provided to a class rather than the class creating those dependencies itself.
	private DataService dataService;
	
	public SomeBusinessImpl(DataService dataService) {
		super();
		this.dataService = dataService;
	}

	// Find and return the greatest (maximum) value from a dataset retrieved through the DataService.
	public int findTheGreatestFromAllData() {
		
		// Return an array of integers (int[] data). Retrieves all available data to be processed.
		int[] data = dataService.retrieveAllData();
		
		// greatestValue is initialized with the smallest possible integer value in Java that serves as a baseline for comparison. Values in dataset will be larger than this value.
		int greatestValue = Integer.MIN_VALUE;
		
		// Iterate over the data using a for-each loop to check if each value is greater than the greatestValue and if so it updates the greatestValue to the current value.
		for(int value : data) {
			if(value > greatestValue)
				greatestValue = value;
		}
		// Greatest value is found and returned.
		return greatestValue;
	}
}

//This class will depend on an interface in the data layer.
interface DataService {
	int[] retrieveAllData();
}

