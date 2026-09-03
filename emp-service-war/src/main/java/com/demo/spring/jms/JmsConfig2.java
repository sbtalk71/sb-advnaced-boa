package com.demo.spring.jms;

import java.util.List;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jndi.JndiTemplate;

import jakarta.jms.ConnectionFactory;
import jakarta.jms.Queue;

@Configuration
@EnableJms
public class JmsConfig2 {

	 @Bean
	    public ConnectionFactory connectionFactory() throws Exception {
	        ConnectionFactory cf= new JndiTemplate().lookup(
	            "java:comp/env/jms/MyConnectionFactory",
	            ConnectionFactory.class
	        );
	        
	        if (cf instanceof ActiveMQConnectionFactory amq) {
	            amq.setTrustedPackages(
	                List.of("com.demo.spring.entities")
	            );
	        }
	        return cf;
	    }
	@Bean
	public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory) throws Exception {

		return new JmsTemplate(connectionFactory);
	}

	@Bean
	public Queue employeeQueue() throws Exception {

		return new JndiTemplate().lookup("java:comp/env/jms/EmployeeQueue", Queue.class);
	}
}