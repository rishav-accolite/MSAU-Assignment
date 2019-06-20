package com.unit.mockit;

import java.util.List;

public class SalaryManager {
	private List<Employee> employees;
	private IEmployeeService empService;
	public SalaryManager() {
	
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	public IEmployeeService getEmpService() {
		return empService;
	}
	public void setEmpService(IEmployeeService empService) {
		this.empService = empService;
	}
	public double getGrossSalary(Employee e)
	{
		//some logic
		int bs=empService.getBasicSalary(e);
		return bs+0.20*bs;
	}

}
