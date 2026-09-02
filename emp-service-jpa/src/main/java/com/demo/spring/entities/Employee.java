package com.demo.spring.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQueries;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "MYEMP")
@NamedStoredProcedureQuery(name = "getAllEmployees", procedureName = "get_all_employees") 
public class Employee implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EMPNO")
	private Integer empId;

	private String name;

	@Column(name = "ADDRESS")
	private String city;

	private Double salary;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, String city, Double salary) {
		this.name = name;
		this.city = city;
		this.salary = salary;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

}
