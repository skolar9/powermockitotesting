package com.mockito.project.service.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import com.mockito.project.service.CalculatorService;

@RunWith(PowerMockRunner.class)
public class CalculatorServiceTest {

    private CalculatorService calculatorService = new CalculatorService();
	 @Test
	 public void add_for_givenTwoInteger_shouldReturn_sumOfTwo() {
		// CalculatorService spiedCalService = PowerMockito.spy(calculatorService);
		 Assert.assertEquals("Test case to check if add returns sum of two give positive numbers", 3, calculatorService.add(1, 2));
	    }
	 @Test
	 public void subract_for_givenTwoInteger_shouldReturn_subOfTwo() {
		// CalculatorService spiedCalService = PowerMockito.spy(calculatorService);
		 Assert.assertEquals("Test case to check if add returns sum of two give positive numbers", -1, calculatorService.subtract(1, 2));
	    }
}


