package com.mockito.project.service.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.mockito.project.service.MyDictionary;

@RunWith(PowerMockRunner.class)
@PrepareForTest({MyDictionary.class})
public class MyDictionaryTest {

	//For non void methods thenthrow
	@Test(expected = NullPointerException.class)
	public void whenConfigNonVoidRetunMethodToThrowEx_thenExIsThrown() {
	    MyDictionary dictMock = PowerMockito.mock(MyDictionary.class);
	    PowerMockito.when(dictMock.getMeaning(ArgumentMatchers.anyString())) //when does not compile with out return value
	      .thenThrow(NullPointerException.class);
	 
	    dictMock.getMeaning("word");
	}
	
	//For void methods dothrow
	@Test(expected = IllegalStateException.class)
	public void whenConfigVoidRetunMethodToThrowExWithNewExObj_thenExIsThrown() {
	    MyDictionary dictMock = PowerMockito.mock(MyDictionary.class);
	    PowerMockito.doThrow(new IllegalStateException("Error occurred"))
	      .when(dictMock)
	      .add(ArgumentMatchers.anyString(), ArgumentMatchers.anyString());
	 
	    dictMock.add("word", "meaning");
	}
	
	@Test
	  public void testVoidMethodThrowingExcetion() {
		MyDictionary mock = PowerMockito.mock(MyDictionary.class);
	    Mockito.doNothing().when(mock).voidMethodThrowingExcetion(false);
	    mock.voidMethodThrowingExcetion(false);
	    Mockito.doThrow(new IllegalArgumentException()).when(mock).voidMethodThrowingExcetion(true);
	    try {
	      mock.voidMethodThrowingExcetion(true);
	      Assert.fail();
	    } catch (IllegalArgumentException e) {
	      // Expected
	    }
	  }
}
