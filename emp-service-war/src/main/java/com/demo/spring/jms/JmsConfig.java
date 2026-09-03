package com.demo.spring.jms;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

import jakarta.jms.ConnectionFactory;
import jakarta.jms.Queue;

@Configuration
@EnableJms
public class JmsConfig {

    @Bean
    public ConnectionFactory connectionFactory()
            throws NamingException {

        InitialContext context = new InitialContext();

        Object object = context.lookup(
                "java:comp/env/jms/MyConnectionFactory");

        System.out.println(
                "JNDI CF = " + object.getClass());

        return (ConnectionFactory) object;
    }

    @Bean
    public Queue employeeQueue()
            throws NamingException {

        InitialContext context = new InitialContext();

        Object object = context.lookup(
                "java:comp/env/jms/EmployeeQueue");

        System.out.println(
                "JNDI Queue = " + object.getClass());

        return (Queue) object;
    }

    @Bean
    public JmsTemplate jmsTemplate(
            ConnectionFactory connectionFactory) {

        return new JmsTemplate(connectionFactory);
    }
}