package com.demo.spring;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.autoconfigure.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


	//@Bean
	@ConfigurationProperties("app.datasource.mysql")
	DataSourceProperties mysqlProperties() {
		System.out.println("db properties read..");
		return new DataSourceProperties();
	}

	//@Bean
	DataSource mySqlDataSource() {
		return mysqlProperties().initializeDataSourceBuilder().type(BasicDataSource.class).build();
	}
	
	//@Bean
	DataSource myDs2() {
		BasicDataSource ds= new BasicDataSource();
		ds.setUrl("jdbc:mysql://localhost:3306/springdb");
		ds.setUsername("root");
		ds.setPassword("P@ssword");
		return ds;
	}
}
