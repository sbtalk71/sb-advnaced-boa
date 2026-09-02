package com.demo.spring;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class CustomJpaConfig {

	private DataSource dataSource;

	public CustomJpaConfig(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
@Bean
LocalContainerEntityManagerFactoryBean myEntityManagerFactory() {
	LocalContainerEntityManagerFactoryBean lcfb=new LocalContainerEntityManagerFactoryBean();
	lcfb.setDataSource(dataSource);
	lcfb.setPackagesToScan("com.demo.spring.entities");
	lcfb.setPersistenceUnitName("myJpaUnit");
	
	HibernateJpaVendorAdapter hva=new HibernateJpaVendorAdapter();
	hva.setDatabase(Database.MYSQL);
	hva.setShowSql(true);
	lcfb.setJpaVendorAdapter(hva);
	return lcfb;
}

@Bean
PlatformTransactionManager myTransactionManager() {
	
	JpaTransactionManager txm=new JpaTransactionManager(myEntityManagerFactory().getObject());
	return txm;
}
}
