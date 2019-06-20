package com.unit.mockit;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

class SalaryManagerTest {
	private SalaryManager sm;

	@BeforeEach
	void setUp() throws Exception {
		sm=new SalaryManager();
	}

	@AfterEach
	void tearDown() throws Exception {
		System.gc();
	}

	@SuppressWarnings("deprecation")
	@Test
	void testGetGrossSalary() {
		Employee e1=new Employee(1, "Rishav");
		Employee e2=new Employee(2,"Shikhar");
		List<Employee> employees=Arrays.asList(e1,e2);
		sm.setEmployees(employees);
		IEmployeeService empService=mock(IEmployeeService.class);
		sm.setEmpService(empService);
		when(empService.getBasicSalary(e1)).thenReturn(58000);
		when(empService.getBasicSalary(e2)).thenReturn(58000);
		assertEquals(69600.0,sm.getGrossSalary(e1),0);
		assertEquals(69600,sm.getGrossSalary(e2),0);
		
		
	}

}
