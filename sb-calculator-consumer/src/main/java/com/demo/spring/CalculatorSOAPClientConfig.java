package com.demo.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;

@Configuration
public class CalculatorSOAPClientConfig {


	@Bean
	SaajSoapMessageFactory messageFactory() {
		return new SaajSoapMessageFactory();
	}
	
	@Bean
	Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller=new Jaxb2Marshaller();
		marshaller.setContextPath("com.example.calculator");
		return marshaller;
	}
	
	@Bean
	WebServiceTemplate webServiceTemplate(SaajSoapMessageFactory messageFactory) {
		
		WebServiceTemplate wsTemplate=new WebServiceTemplate(messageFactory);
		wsTemplate.setMarshaller(marshaller());
		wsTemplate.setUnmarshaller(marshaller());
		wsTemplate.setDefaultUri("http://localhost:8181/ws");
		return wsTemplate;
	}
}
