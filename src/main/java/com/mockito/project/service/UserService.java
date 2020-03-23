package com.mockito.project.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	List<String> users= Arrays.asList("a","b");
	
	public List<String> getUsers() {
		return users;
	}

}
