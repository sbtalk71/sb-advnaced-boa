package com.demo.spring.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.demo.spring.Notification;

@Component
@Profile({"dev","prod"})
public class SMSNotification2 implements Notification {

	@Override
	public void send(String message) {
		System.out.printf("SMS Sent : %s",message);

	}

}
