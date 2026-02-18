package org.jsp.employee_management.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.employee_management.dto.Employee;
import org.jsp.employee_management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {
	
	@Autowired
	private EmployeeRepository repository;
	
	public Employee addEmployee(Employee employee) {
		return repository.save(employee);
	}
	
	public Optional<Employee> getEmployeeById(int id){
		Optional<Employee> employee = repository.findById(id);
		return employee;
	}
	
	public List<Employee> getAllEmployees(){
		List<Employee> employees = repository.findAll();
		return employees;
	}
	
	public Employee updateEmployee(Employee employee) {
		return repository.save(employee);
	}
	
	public void deleteEmployee(Employee employee) {
		repository.delete(employee);
	}
	public void deleteEmployeeById(int id) {
		repository.deleteById(id);
	}
	public List<Employee> searchByName(String name){
		return repository.findByNameContaining(name);
	}
	
	public double findSalaryByName(String name) {
		return repository.findSalaryByName(name);
	}

	public List<Employee> getAllSortedBySalary(){
		return repository.findAll(Sort.by("salary"));
		
		//returns list of employees in ascending(default) order of salaries
		//for descending findAll(Sort.by("salary").descending());
	}
}
