package com.demo.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.example.calculator.AddRequest;
import com.example.calculator.AddResponse;

@Component
public class WsClientRunner implements CommandLineRunner {

	private WebServiceTemplate wsTemplate;
	
	public WsClientRunner(WebServiceTemplate wsTemplate) {
		this.wsTemplate = wsTemplate;
	}

	@Override
	public void run(String... args) throws Exception {
		
		AddRequest request= new AddRequest();
		request.setA(20);
		request.setB(30);
		
		AddResponse response=(AddResponse)wsTemplate.marshalSendAndReceive(request);
		System.out.println(response.getResult());

	}

}
