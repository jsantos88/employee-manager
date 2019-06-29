package com.django.test.repository;

import org.springframework.stereotype.Repository;

import com.django.test.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
