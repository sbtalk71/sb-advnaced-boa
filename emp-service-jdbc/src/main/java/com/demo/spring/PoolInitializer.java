package com.demo.spring;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.demo.spring.entities.Employee;

@Component
public class PoolInitializer implements CommandLineRunner {

	private final DataSource mySqlDataSource;
	@Autowired
	JdbcTemplate jdbcTemplate;

	PoolInitializer(DataSource mySqlDataSource) {
		this.mySqlDataSource = mySqlDataSource;
	}

	@Override
	public void run(String... args) throws Exception {

		CallableStatementCreator callable = new CallableStatementCreator() {

			@Override
			public CallableStatement createCallableStatement(Connection con) throws SQLException {
				CallableStatement cst = con.prepareCall("{CALL get_all_employees()}");
				return cst;
			}
		};

		List<Employee> empList = jdbcTemplate.execute(callable, new CallableStatementCallback<List<Employee>>() {

			@Override
			public List<Employee> doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
				ResultSet rs = cs.getResultSet();
				List<Employee> list = new ArrayList<>();
				if (rs != null) {
					while (rs.next()) {
						list.add(new Employee(rs.getInt("EMPNO"), rs.getString("NAME"), rs.getString("ADDRESS"),
								rs.getDouble("SALARY")));
					}
				}
				return list;
			};
		});
		empList.forEach(emp -> System.out.println(emp.getName()));
	}
}
