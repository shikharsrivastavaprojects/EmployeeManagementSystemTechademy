package com.amdocs.EmployeeSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.EmployeeSystem.entity.Employee;
import com.amdocs.EmployeeSystem.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("api/employees")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
		Employee savedEmployee = employeeService.createEmployee(employee);
		return new ResponseEntity<>(savedEmployee,HttpStatus.CREATED);
	}
	
	@GetMapping("api/employees/{id}")
	public ResponseEntity<Employee>getEmployeeById(@PathVariable("id")Long employeeId){
		Employee employee = employeeService.getEmployeeById(employeeId);
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	
	@GetMapping("api/employees")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> employees = employeeService.getAllEmployees();
		return new ResponseEntity<>(employees,HttpStatus.OK);
	}
	
	@PutMapping("api/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id")Long employeeId,@RequestBody Employee employee){
		employee.setId(employeeId);
		Employee updatedEmployee = employeeService.updateEmployee(employee);
		return new ResponseEntity<>(updatedEmployee,HttpStatus.OK);
	}
	
	@DeleteMapping("api/employees/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id")Long employeeId){
		employeeService.deleteEmployee(employeeId);
		return new ResponseEntity<>("User successfully deleted!",HttpStatus.OK);
	}

}
