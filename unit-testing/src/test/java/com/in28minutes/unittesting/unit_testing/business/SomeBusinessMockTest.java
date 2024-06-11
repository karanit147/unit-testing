package com.in28minutes.unittesting.unit_testing.business;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.in28minutes.unittesting.unit_testing.data.SomeDataService;

@ExtendWith(MockitoExtension.class)
class SomeBusinessMockTest {
	
	@InjectMocks
	private SomeBusinessImpl business;
	
	@Mock
	private SomeDataService dataServiceMock;
	
//	SomeBusinessImpl business = new SomeBusinessImpl();
//	SomeDataService dataServiceMock = mock(SomeDataService.class);
	
//	@BeforeEach
//	public void before() {
//		business.setSomeDataService(dataServiceMock);
//	}

	@Test
	public void calculateSumUsingDataService_basic() {
		
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,3});
		assertEquals(6, business.calculateSumUsingDataService());
	}
	
	@Test
	public void calculateSumUsingDataService_empty() {

		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		assertEquals(0, business.calculateSumUsingDataService());
	}
	
	@Test
	public void calculateSumUsingDataService_oneValue() {

		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {5});
		assertEquals(5, business.calculateSumUsingDataService());
	}
	
}