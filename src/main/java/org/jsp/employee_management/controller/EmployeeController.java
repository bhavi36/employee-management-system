package org.jsp.employee_management.controller;

import java.util.List;

import org.jsp.employee_management.dto.Employee;
import org.jsp.employee_management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee employee) {
		return service.addEmployee(employee);
	}
	
	@GetMapping("/get_by_id/{id}")
	public Employee getEmployeeById(@PathVariable int id){
		
		return service.getEmployeeById(id);
	}
	@GetMapping("/get_all")
	public List<Employee> getAllEmployees(){
		return service.getAllEmployees();
	}
	
	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return service.updateEmployee(employee);
	}
	@DeleteMapping("/delete")
	public void deleteEmployee(@RequestBody Employee employee) {
		service.deleteEmployee(employee);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteEmployeeById(@PathVariable int id) {
		service.deleteEmployeeById(id);
	}
	
	@GetMapping("/search/{name}")
	public List<Employee> searchByName(@PathVariable String name){
		return service.searchByName(name);
	}
	
	@GetMapping("/search_sal_by_name/{name}")
	public double getSalaryByName(@PathVariable String name) {
		return service.findSalaryByName(name);
	}
	
	@GetMapping("/get_sorted")
	public List<Employee> getAllSortedBySalary(){
		return service.getAllSortedBySalary();
	}
}
