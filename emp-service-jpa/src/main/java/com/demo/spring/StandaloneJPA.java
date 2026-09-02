package com.demo.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.demo.spring.entities.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

//@Component
public class StandaloneJPA implements CommandLineRunner{

	@PersistenceContext
	EntityManager em;
	
	@Override
	@Transactional
	public void run(String... args) throws Exception {
		System.out.println("inside run method...");
		
		Employee emp=new Employee("Shekhar","Chennai",60000.0);
		
		em.persist(emp);
		
	}
}
