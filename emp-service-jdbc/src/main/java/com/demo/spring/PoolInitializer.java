package com.demo.spring;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PoolInitializer implements CommandLineRunner {

	@Autowired
	@Qualifier("myDs2")
	DataSource dataSource;
	@Override
	public void run(String... args) throws Exception {
	Connection conn=	dataSource.getConnection();
	if(conn!=null) {
		conn.close();
	}
	}

}
