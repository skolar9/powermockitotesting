package com.mockito.project.service.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.mockito.project.model.Employee;
import com.mockito.project.service.StudentScoreUpdates;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ StudentScoreUpdates.class })
public class StudentScorestest {
	@InjectMocks
	StudentScoreUpdates studentScoreUpdates;

	@Test
	public void calculateSumAndStore_withValidInput_shouldCalculateAndUpdateResultInDb() {
		StudentScoreUpdates s = PowerMockito.spy(studentScoreUpdates);
		int[] scores = { 60, 70, 90 };
		PowerMockito.doNothing().when(s).updateScores(ArgumentMatchers.anyString(), ArgumentMatchers.anyInt());
		s.calculateSumAndStore("student1", scores);
	}

	@Test
	public void calculateSumAndStore_withValidInput_shouldCalculateAndUpdateResultInDb_1() {
		StudentScoreUpdates s = PowerMockito.spy(studentScoreUpdates);
		int[] scores = { 60, 70, 90 };
		  PowerMockito.doAnswer(invocation -> { 
			      Object[] args = invocation.getArguments();
			      System.out.println(args[1]); 
				  Object mock = invocation.getMock();
				  return mock;
		  }).when(s).updateScores(ArgumentMatchers.anyString(),
		  ArgumentMatchers.anyInt());
		s.calculateSumAndStore("Student1", scores);
	}
	
	
	@Test
	public void test_mockito_void() {
		Employee emp = PowerMockito.mock(Employee.class);
		PowerMockito.doAnswer((i) -> {
			System.out.println("Employee setName Argument = " + i.getArgument(0));
			assertTrue("Pankaj".equals(i.getArgument(0)));
			return null;
		}).when(emp).setfName(ArgumentMatchers.anyString());
		emp.setfName("Pankaj");
	}
}
