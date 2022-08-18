package com.emp.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.model.Employee;

public interface IEmployeeRepositary extends JpaRepository<Employee, Integer> {

}
