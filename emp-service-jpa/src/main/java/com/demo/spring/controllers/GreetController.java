package com.demo.spring.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

	@GetMapping(path="/greet/{name}")
	public ResponseEntity<String> greetMessage( @PathVariable("name") String userName) {
		return ResponseEntity.ok("Hello "+userName+" from REST");
	}
}
