package com.amdocs.EmployeeSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.EmployeeSystem.entity.Employee;
import com.amdocs.EmployeeSystem.repo.EmployeeRepository;

@Service

public class EmployeeServiceIMPL implements EmployeeService {
	
	@Autowired
	public EmployeeRepository employeeRepository;

	@Override
	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(Long employeeId) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(employeeId).get();
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Employee existingEmployee = employeeRepository.findById(employee.getId()).get();
		existingEmployee.setName(employee.getName());
		existingEmployee.setEmail(employee.getEmail());
		Employee updateEmployee = employeeRepository.save(existingEmployee);
		return updateEmployee;
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(employeeId);
	}

}
