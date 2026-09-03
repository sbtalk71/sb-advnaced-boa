package com.demo.spring.jms;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.demo.spring.entities.Employee;

import jakarta.jms.Queue;

@Service
public class EmployeeMessageService {

	private final JmsTemplate jmsTemplate;
	private final Queue employeeQueue;

	public EmployeeMessageService(JmsTemplate jmsTemplate, Queue employeeQueue) {

		this.jmsTemplate = jmsTemplate;
		this.employeeQueue = employeeQueue;
	}

	public void send(Employee employee) {

		jmsTemplate.convertAndSend(employeeQueue, employee);
	}
}