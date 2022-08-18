package com.emp.service;

import java.util.List;
import java.util.Optional;

import com.emp.model.Employee;

public interface IEmployeeService {

	Integer saveEmployee(Employee employee);
	
	public List<Employee> getAllEmployee();
	
	Optional<Employee> getEmployee(Integer Id);
	
	public void deleteEmployee(Integer Id);
	
	public void deleteAllEmployee();
	
	Employee updateEmployee(Employee employee,Integer id);
	
}
