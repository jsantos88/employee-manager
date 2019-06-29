package com.django.test.service;

import java.util.List;

import com.django.test.model.Employee;

public interface EmployeeService {
	
	List<Employee> findAll();
	
	Employee createEmployee(Employee employee);
	
	void delete(Long id);

}
