package com.demo.spring;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.demo.spring.entities.Employee;

@Repository
public class HashMapRepository {

	public HashMap<Integer,Employee> employees=new HashMap<>();
	
	public HashMapRepository() {
		employees.put(100, new Employee(100,"Shantanu","Hyderabad",78000.0));
		employees.put(101, new Employee(101,"Shantanu","Hyderabad",78000.0));
		employees.put(102, new Employee(102,"Shantanu","Hyderabad",78000.0));
	}
	
	public HashMap<Integer, Employee> getEmployees(){
		return employees;
	}
}
