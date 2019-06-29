package com.django.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue
	@JsonIgnore
	private Long id;
	
	@Column
	@NotNull
	private String name;
	
	@Column
	@Email
	@NotNull
	private String email;
	
	@Column
	@NotNull
	private String department;
	
	Employee() {
		
	}
	
	public Employee(final String name, final String email, final String department) {
		this.name = name;
		this.email = email;
		this.department = department;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getDepartment() {
		return department;
	}

}
