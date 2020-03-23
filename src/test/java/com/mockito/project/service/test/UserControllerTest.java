package com.mockito.project.service.test;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.mockito.controller.UserController;
import com.mockito.project.service.UserService;

@RunWith(PowerMockRunner.class)
@PrepareForTest({UserService.class})
public class UserControllerTest {

	@Mock
	UserService userService;
	
	@InjectMocks
	UserController userController;
	
	@Test
	public void userCountTest_null() {
		List<String> users= null;
		PowerMockito.when(userService.getUsers()).thenReturn(users);
		String result = userController.getUserCount();
		Assert.assertEquals("0",result);
	}
	
	@Test
	public void userCountTest() {
		List<String> users= Arrays.asList("a","b");
		PowerMockito.when(userService.getUsers()).thenReturn(users);
		String result = userController.getUserCount();
		Assert.assertEquals("2",result);
	}
}
