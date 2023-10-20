package com.amdocs.EmployeeSystem.service;

import java.util.List;

import com.amdocs.EmployeeSystem.entity.Employee;

public interface EmployeeService {
	
	Employee createEmployee(Employee employee);
	
	Employee getEmployeeById(Long employeeId);
	
	List<Employee> getAllEmployees();
	
	Employee updateEmployee(Employee employee);
	
	void deleteEmployee(Long employeeId);

}
