package com.demo.spring.controllers;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.EmpService;
import com.demo.spring.entities.Employee;

@RestController
@RequestMapping("/emp")
public class EmpController {

	private EmpService empService;

	public EmpController(EmpService empService) {
		this.empService = empService;
	}

	@GetMapping( path="/{id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> findOneEmp(@PathVariable("id") Integer id){
		return ResponseEntity.ok(empService.findEmp(id));
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> getAll() {
		return ResponseEntity.ok(empService.getEmpList());
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> saveToDb(@RequestBody Employee employee) {
		return ResponseEntity.ok(empService.saveEmp(employee));
	}
	
	@DeleteMapping(path="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deletEmp(@PathVariable Integer id)
	{
		return ResponseEntity.ok(empService.delete(id));
	}
	
}
