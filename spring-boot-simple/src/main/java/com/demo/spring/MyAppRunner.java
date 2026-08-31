package com.demo.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.spring.service.OrderService;

@Component
public class MyAppRunner implements CommandLineRunner {

	private OrderService orderService;
		
	public MyAppRunner(OrderService orderService) {
		this.orderService = orderService;
	}


	@Override
	public void run(String... args) throws Exception {
		
		orderService.sendNotification();

	}

}
