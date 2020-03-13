package com.mockito.project.service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.mockito.project.service.MyDictionary;
import com.mockito.project.service.StudentScoreUpdates;

@RunWith(PowerMockRunner.class)
@PrepareForTest({MyDictionary.class, StudentScoreUpdates.class})
public class DictionaryTest {
	
	@InjectMocks
	MyDictionary myDictionary;
	
	@Test
	public void calculateSumAndStore_withValidInput_shouldCalculateAndUpdateResultInDb_2() {
		MyDictionary spiedmyDictionary = PowerMockito.spy(myDictionary);
		//StudentScoreUpdates s = PowerMockito.mock(StudentScoreUpdates.class);
		int[] scores = { 60, 70, 90 };
	
		spiedmyDictionary.calculateSumAndStore_1("sree",scores);
	}

}
