package com.mockito.project.service;

public class EmployeeUtils {

	public static String getInitials(String fName, String lName) {
		return fName.charAt(0) + lName.charAt(0) + "";
	}

	public static String concat(String a, String b) {
		String c= a+b;
		return c;
	}

	

}
