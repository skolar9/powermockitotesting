package com.mockito.project.service;

import org.springframework.stereotype.Service;

import com.mockito.project.model.Employee;
import com.mockito.project.model.EmployeeDto;

@Service
public class EmployeeService {
	
	 public EmployeeDto fetchEmployee(final Employee employee) {
	        final EmployeeDto employeeDto = new EmployeeDto();
	        employeeDto.setfName(employee.getfName());
	        employeeDto.setlName(employee.getlName());
	        employeeDto.setInitials(getEmployeeInitials(employee.getfName(), employee.getlName()));
	        return employeeDto;
	    }

	    public EmployeeDto fetchEmployeeStatically(final Employee employee) {
	        final EmployeeDto employeeDto = new EmployeeDto();
	        employeeDto.setfName(employee.getfName());
	        employeeDto.setlName(employee.getlName());
	        employeeDto.setInitials(EmployeeUtils.getInitials(employee.getfName(), employee.getlName()));
	        return employeeDto;
	    }

	    private String getEmployeeInitials(final String fName, final String lName) {
	        return fName.charAt(0) + lName.charAt(1) + "";
	    }
	    
	    public String out(String a,String b) {
	    	String c = EmployeeUtils.concat(a,b);
	    	return c;
	    }

}
