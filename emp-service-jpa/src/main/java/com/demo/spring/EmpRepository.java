package com.demo.spring;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.spring.entities.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer>{

}
