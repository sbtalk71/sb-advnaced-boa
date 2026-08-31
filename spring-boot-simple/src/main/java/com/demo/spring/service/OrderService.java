package com.demo.spring.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.demo.spring.Notification;

@Service
public class OrderService {

@Value("${order.message:message load failed}")
private String message;

private Notification notification;


public OrderService(Notification notification) {
	this.notification = notification;
}



public void sendNotification() {
	notification.send(message);
}
}
