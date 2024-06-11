package com.in28minutes.unittesting.unit_testing.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

class ListMockTest {
	
	List<String> mock = mock(List.class); 

	@Test
	public void size_basic() {
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5,  mock.size());
	}
	
	@Test
	public void returnDifferentValues() {
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5,  mock.size());
		assertEquals(10,  mock.size());
	}
	
	@Test
	public void returnWithParameters() {
		when(mock.get(0)).thenReturn("in28minutes");
		assertEquals("in28minutes", mock.get(0));
		assertEquals(null,  mock.get(1));
	}
	
	@Test
	public void returnWithGenericParameters() {
		when(mock.get(anyInt())).thenReturn("in28minutes");
		assertEquals("in28minutes", mock.get(0));
		assertEquals("in28minutes",  mock.get(1));
	}
	
	@Test
	public void verificationBasic() {
		
		String value1 = mock.get(0);
		String value2 = mock.get(1);
		
		verify(mock).get(0);
		verify(mock).get(1);
		verify(mock, times(2)).get(anyInt());
		verify(mock, atLeast(1)).get(anyInt());
		verify(mock, atMost(2)).get(anyInt());
		verify(mock, never()).get(2);
	}
	
	@Test
	public void argumentCapturing() {
		
		mock.add("SomeString");
		
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class); 
		
		verify(mock).add(captor.capture());
		assertEquals("SomeString", captor.getValue());
		
	}
	
	@Test
	public void multipleArgumentCapturing() {
		
		mock.add("SomeString1");
		mock.add("SomeString2");
		
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class); 
		
		verify(mock, times(2)).add(captor.capture());
		
		List<String> allValues = captor.getAllValues();
		assertEquals("SomeString1", allValues.get(0));
		assertEquals("SomeString2", allValues.get(1));
		 
	}
	
	@Test
	public void mocking() {
		ArrayList arrayListMock = mock(ArrayList.class);
		
		System.out.println(arrayListMock.get(0)); //null
		System.out.println(arrayListMock.size()); //0
		arrayListMock.add("Test");
		arrayListMock.add("Test2");
		System.out.println(arrayListMock.size());
		
		when(arrayListMock.size()).thenReturn(5);
		System.out.println(arrayListMock.size()); 
		
	}
	
	@Test
	public void spying() {
		ArrayList arrayListSpy = spy(ArrayList.class);
		
//		spy will hold the original dependency and not a mocked one
		
		arrayListSpy.add("Test");		
		System.out.println(arrayListSpy.get(0)); //Test
		System.out.println(arrayListSpy.size()); //1
		arrayListSpy.add("Test1");
		arrayListSpy.add("Test2");
		System.out.println(arrayListSpy.size()); //3
		
		when(arrayListSpy.size()).thenReturn(5);
		System.out.println(arrayListSpy.size()); //5
		
		arrayListSpy.add("Test4");
		System.out.println(arrayListSpy.size()); //5  -> retains 5 because we made use of when and return value
		
		verify(arrayListSpy).add("Test4");
		
	}

}
