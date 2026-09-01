package com.demo.spring.dao;

import java.util.List;
import java.util.Optional;

import com.demo.spring.entities.Employee;

public interface EmpDao {

	public List<Employee> findAllEmps();
	public Employee findEmpById(Integer id);
	public Employee save(Employee employee);
	public void update(Employee employee);
	public void deleteById(Integer id);
}
