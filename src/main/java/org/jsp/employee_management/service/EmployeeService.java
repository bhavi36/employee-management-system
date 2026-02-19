package org.jsp.employee_management.service;

import java.util.List;
import java.util.Optional;

import org.jsp.employee_management.dao.EmployeeDao;
import org.jsp.employee_management.dto.Employee;
import org.jsp.employee_management.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;

	public Employee addEmployee(Employee employee) {
		
		if(employeeDao.getEmployeeById(employee.getId()).isPresent()) {
			throw new ResourceNotFoundException("User is already existed...");
		}
		return employeeDao.addEmployee(employee);
	}
	
	public Employee getEmployeeById(int id){
		Optional<Employee> emp = employeeDao.getEmployeeById(id);
		Employee employee = emp.orElseThrow(() -> new ResourceNotFoundException("Employee Not available with given id..."));
		
		return employee;
	}
	
	public List<Employee> getAllEmployees(){
		List<Employee> employees = employeeDao.getAllEmployees();
		return employees;
	}
	
	public Employee updateEmployee(Employee employee) {
		return employeeDao.updateEmployee(employee);
	}
	 	
	public void deleteEmployee(Employee employee) {
		employeeDao.deleteEmployee(employee);
	}
	public void deleteEmployeeById(int id) {
		employeeDao.deleteEmployeeById(id);
	}
	public List<Employee> searchByName(String name){
		if(employeeDao.searchByName(name).isEmpty()) {
			throw new ResourceNotFoundException("Searched name is not available...");
		}
		return employeeDao.searchByName(name);
	}
	public double findSalaryByName(String name) {
		return employeeDao.findSalaryByName(name);
	}
	
	public List<Employee> getAllSortedBySalary(){
		return employeeDao.getAllSortedBySalary();
	}
	
}
