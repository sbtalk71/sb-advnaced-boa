package com.demo.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.demo.spring.Notification;
import com.demo.spring.impl.EmailNotification;

@Configuration
@ComponentScan(basePackages = "com.demo.spring")
public class AppConfig {

	@Bean
	public Notification myEmailNotification() {
		return new EmailNotification();
	}
}
