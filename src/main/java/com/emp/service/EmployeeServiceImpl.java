package com.emp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.exception.ResourceNotFoundException;
import com.emp.model.Employee;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	IEmployeeRepositary employeeRepositary;

	@Override
	public Integer saveEmployee(Employee employee) {
	Employee saveEmployee = employeeRepositary.save(employee);
	return saveEmployee.getId();
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepositary.findAll();
	}

	@Override
	public Optional<Employee> getEmployee(Integer Id) {
		
		return employeeRepositary.findById(Id);
	
	}

	@Override
	public void deleteEmployee(Integer Id) {
		
		employeeRepositary.deleteById(Id);
		
	}

	@Override
	public void deleteAllEmployee() {
		
		employeeRepositary.deleteAll();		
	}

	@Override
	public Employee updateEmployee(Employee employee, Integer id) {
		Employee existingEmployee= employeeRepositary.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee", "id", id));
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		employeeRepositary.save(existingEmployee);	
		return existingEmployee;
	}

	
	
}
