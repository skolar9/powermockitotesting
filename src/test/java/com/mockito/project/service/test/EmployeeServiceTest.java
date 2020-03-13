package com.mockito.project.service.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.mockito.project.model.Employee;
import com.mockito.project.model.EmployeeDto;
import com.mockito.project.service.EmployeeService;
import com.mockito.project.service.EmployeeUtils;

@RunWith(PowerMockRunner.class)
@PrepareForTest({EmployeeService.class, EmployeeUtils.class})
public class EmployeeServiceTest{
	 	@InjectMocks
	    private EmployeeService employeeService;

	 	@Test
	 	public void testout() {
	 		EmployeeService spiedEmpService = PowerMockito.spy(employeeService);
	 		PowerMockito.mockStatic(EmployeeUtils.class);
		    PowerMockito.when(EmployeeUtils.concat("a", "b")).thenReturn("ab");
	 		Assert.assertEquals(spiedEmpService.out("a", "b"),"ab" );
	 	}
	 	
	    @Test
	    public void fetchEmployee() throws Exception {
	        final EmployeeService spiedEmpService = PowerMockito.spy(employeeService);
	        final Employee employee = new Employee();
	        employee.setfName("Dexter");
	        employee.setlName("Morgan");
	        PowerMockito.doReturn("DM").when(spiedEmpService, "getEmployeeInitials", ArgumentMatchers.anyString(), ArgumentMatchers.anyString());
	        final EmployeeDto employeeDto = spiedEmpService.fetchEmployee(employee);
	        Assert.assertNotNull(employeeDto);
	        Assert.assertEquals("DM", employeeDto.getInitials());
	    }

	    @Test
	    public void fetchEmployee_static() throws Exception {
	        PowerMockito.mockStatic(EmployeeUtils.class);
	        PowerMockito.when(EmployeeUtils.getInitials("Dexter", "Morgan")).thenReturn("DM");
	        final Employee employee = new Employee();
	        employee.setfName("Dexter");
	        employee.setlName("Morgan");
	        final EmployeeDto employeeDto = employeeService.fetchEmployeeStatically(employee);
	        Assert.assertNotNull(employeeDto);
	        Assert.assertEquals("DM", employeeDto.getInitials());
	    }

}
