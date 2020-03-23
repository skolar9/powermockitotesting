package com.mockito.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mockito.project.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	public String getUserCount() {
		List<String> users = userService.getUsers();
		Integer i=0;
		if(users!=null && users.size()>0) {
		 i = users.size(); 
		}
		int result= i%10;
		return Integer.toString(result);
		
	}

}
