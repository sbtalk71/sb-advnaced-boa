package com.demo.spring;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class MyPoolInitializer implements CommandLineRunner {

	private DataSource dataSource;
	
	public MyPoolInitializer(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void run(String... args) throws Exception {
		Connection conn=dataSource.getConnection();
		if(conn!=null) {
			conn.close();
		}

	}

}
