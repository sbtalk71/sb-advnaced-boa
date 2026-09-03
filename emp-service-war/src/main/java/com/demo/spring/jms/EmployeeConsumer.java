package com.demo.spring.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.demo.spring.entities.Employee;

@Component
public class EmployeeConsumer {

    @JmsListener(
        destination = "employee.queue",
        containerFactory = "jmsListenerContainerFactory"
    )
    public void receive(Employee message) {

        System.out.println("Received: " + message);
    }
}