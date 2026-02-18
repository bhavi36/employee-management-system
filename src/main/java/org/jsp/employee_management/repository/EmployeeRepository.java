package org.jsp.employee_management.repository;

import java.util.List;

import org.jsp.employee_management.dto.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	public List<Employee> findByNameContaining(String name);
	
	@Query("SELECT e.salary from Employee e WHERE e.name=?1")
	public double findSalaryByName(String name);
}
