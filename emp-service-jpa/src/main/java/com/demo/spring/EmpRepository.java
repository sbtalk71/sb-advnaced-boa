package com.demo.spring;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.demo.spring.entities.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer>{

	@Procedure(procedureName = "get_all_employees")
	//@Procedure(name = "getAllEmployees")
	public List<Employee> listAllEmps();
	
	@Query(value = "select empno,name,address,salary from myemp where empno=:empid",nativeQuery = true)
	public Optional<Employee> findOneEmp(@Param("empid") Integer id);
}
