package com.amdocs.EmployeeSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amdocs.EmployeeSystem.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
