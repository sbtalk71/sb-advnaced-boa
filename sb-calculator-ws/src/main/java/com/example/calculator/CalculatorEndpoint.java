package com.example.calculator;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CalculatorEndpoint {

	private static final String NAMESPACE = "http://example.com/calculator";

	private CalculatorService calculatorService;

	public CalculatorEndpoint(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}

	@PayloadRoot(namespace = NAMESPACE, localPart = "addRequest")
	@ResponsePayload
	public AddResponse add(@RequestPayload AddRequest request) {
		int result = calculatorService.add(request.getA(), request.getB());
		AddResponse response = new AddResponse();
		response.setResult(result);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE, localPart = "subtractRequest")
	@ResponsePayload
	public SubtractResponse add(@RequestPayload SubtractRequest request) {
		int result = calculatorService.subtract(request.getA(), request.getB());
		SubtractResponse response = new SubtractResponse();
		response.setResult(result);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE, localPart = "multiplyRequest")
	@ResponsePayload
	public MultiplyResponse add(@RequestPayload MultiplyRequest request) {
		int result = calculatorService.multiply(request.getA(), request.getB());
		MultiplyResponse response = new MultiplyResponse();
		response.setResult(result);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE, localPart = "divideRequest")
	@ResponsePayload
	public DivideResponse divide(@RequestPayload DivideRequest request) {
		double result = calculatorService.divide(request.getA(), request.getB());
		DivideResponse response = new DivideResponse();
		response.setResult(result);
		return response;
	}

}
