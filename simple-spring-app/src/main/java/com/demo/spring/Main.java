package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.spring.config.AppConfig;
import com.demo.spring.service.OrderService;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		
		OrderService orderService=(OrderService)ctx.getBean("orderService");
		
		orderService.sendNotification();

	}

}
