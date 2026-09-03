package com.demo.spring.jms;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.support.destination.DestinationResolver;
import org.springframework.jms.support.destination.JndiDestinationResolver;
import org.springframework.jndi.JndiTemplate;

import jakarta.jms.ConnectionFactory;

@Configuration
public class JmsDestinationConfig {

   

	 @Bean
	    public DefaultJmsListenerContainerFactory
	        jmsListenerContainerFactory(
	            ConnectionFactory connectionFactory) {

	        DefaultJmsListenerContainerFactory factory =
	            new DefaultJmsListenerContainerFactory();

	        factory.setConnectionFactory(connectionFactory);

	        return factory;
	    }
}