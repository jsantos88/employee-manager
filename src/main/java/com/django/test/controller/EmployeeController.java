package com.django.test.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.django.test.model.Employee;
import com.django.test.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> findAll() {
		final List<Employee> employees = employeeService.findAll();
		if (employees == null) {
			return new ResponseEntity<List<Employee>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> create(@RequestBody @Valid Employee employee) {
		final Employee employeeCreated = employeeService.createEmployee(employee);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(employeeCreated.getId()).toUri());
		
        return new ResponseEntity<String>(null, httpHeaders, HttpStatus.CREATED);
	}
	
	@RequestMapping(path="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {

		try {
			employeeService.delete(id);
			return ResponseEntity.noContent().build();
		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

}
