package com.demo.spring.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.HashMapRepository;
import com.demo.spring.entities.Employee;

@RestController
@RequestMapping("/emp")
public class EmpController {

	private HashMapRepository repository;
	
	public EmpController(HashMapRepository repository) {
		this.repository = repository;
	}

	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> getAll(){
		List<Employee> list= new ArrayList<>(repository.getEmployees().values());
		return ResponseEntity.ok(list);
	}
}
