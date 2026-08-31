package com.demo.spring.impl;

import org.springframework.stereotype.Component;

import com.demo.spring.Notification;

@Component
public class EmailNotification implements Notification {

	@Override
	public void send(String message) {
		System.out.printf("Email Sent : %s",message);

	}

}
