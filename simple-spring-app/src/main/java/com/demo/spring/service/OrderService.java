package com.demo.spring.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.demo.spring.Notification;

@Service
public class OrderService {

private Notification notification;


public OrderService(@Qualifier("myEmailNotification") Notification notification) {
	this.notification = notification;
}



public void sendNotification() {
	notification.send("Order Confirmed");
}
}
