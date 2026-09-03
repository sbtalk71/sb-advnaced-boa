package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableCaching
@EnableTransactionManagement()
@EnableJpaRepositories(transactionManagerRef = "myTransactionManager",entityManagerFactoryRef = "myEntityManagerFactory")
public class EmpServiceApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(EmpServiceApplication.class, args);
	}

	
	@Bean
	UserDetailsService userDetailsService() {
		
		InMemoryUserDetailsManager manager= new InMemoryUserDetailsManager();
		
		manager.createUser(User.withUsername("shantanu").roles("USER").password("$2a$10$lHxF4/QuGcBHz4Vw2wJCe.uz8yXV78YhHB6Ay3qLWzaH1avRlfNC6").build());
		manager.createUser(User.withUsername("ranga").roles("ADMIN").password("$2a$10$lHxF4/QuGcBHz4Vw2wJCe.uz8yXV78YhHB6Ay3qLWzaH1avRlfNC6").build());
		manager.createUser(User.withUsername("pavan").roles("USER").password("$2a$10$lHxF4/QuGcBHz4Vw2wJCe.uz8yXV78YhHB6Ay3qLWzaH1avRlfNC6").disabled(true).build());
		return manager;
	}
	
}
