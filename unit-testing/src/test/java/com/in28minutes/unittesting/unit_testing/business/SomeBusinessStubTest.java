package com.in28minutes.unittesting.unit_testing.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.in28minutes.unittesting.unit_testing.data.SomeDataService;

class SomeBusinessStubTest {

	@Test
	public void calculateSumUsingDataService_basic() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new DataServiceStub1());
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void calculateSumUsingDataService_empty() {
		SomeBusinessImpl  business = new SomeBusinessImpl();
		business.setSomeDataService(new DataServiceStub2());
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void calculateSumUsingDataService_oneValue() {
		SomeBusinessImpl  business = new SomeBusinessImpl();
		business.setSomeDataService(new DataServiceStub3());
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 5;
		assertEquals(expectedResult, actualResult);
	}
	
}

class DataServiceStub1 implements SomeDataService {
	@Override
	public int[] retrieveAllData() {
		return new int[] {1,2,3};
	}
}

class DataServiceStub2 implements SomeDataService {
	@Override
	public int[] retrieveAllData() {
		return new int[] {};
	}
}

class DataServiceStub3 implements SomeDataService {
	@Override
	public int[] retrieveAllData() {
		return new int[] {5};
	}
}