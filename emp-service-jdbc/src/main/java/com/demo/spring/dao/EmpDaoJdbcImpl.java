package com.demo.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.demo.spring.entities.Employee;
import com.demo.spring.exceptions.EmployeeExistsException;
import com.demo.spring.exceptions.EmployeeNotFoundException;

@Repository
public class EmpDaoJdbcImpl implements EmpDao {
	private JdbcTemplate jdbcTemplate;

	public EmpDaoJdbcImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Employee> findAllEmps() {
		final String FIND_ALL_QUERY = "select * from myemp";

		List<Employee> empList = jdbcTemplate.query(FIND_ALL_QUERY, new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {

				return new Employee(rs.getInt("EMPNO"), rs.getString("NAME"), rs.getString("ADDRESS"),
						rs.getDouble("SALARY"));
			}

		});
		return empList;
	}

	@Override
	public Employee findEmpById(Integer id) {
		final String FINDER_QUERY = "select * from myemp where empno=" + id;
		Employee emp = null;

		try {
			emp = jdbcTemplate.queryForObject(FINDER_QUERY, new RowMapper<Employee>() {

				@Override
				public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {

					return new Employee(rs.getInt("EMPNO"), rs.getString("NAME"), rs.getString("ADDRESS"),
							rs.getDouble("SALARY"));
				}
			});
		} catch (EmptyResultDataAccessException e) {
			throw new EmployeeNotFoundException("Employee with id " + id + " not found");
		}
		return emp;
	}

	@Override
	public Employee save(Employee employee) {
		final String SAVE_QUERY = "insert into myemp(empno,name,address,salary) values(?,?,?,?)";

		try {
				this.findEmpById(employee.getEmpId());
				throw new EmployeeExistsException("Exp exists");
		} catch (EmployeeNotFoundException e) {
			int saved = jdbcTemplate.update(new PreparedStatementCreator() {
				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement pst = con.prepareStatement(SAVE_QUERY);
					pst.setInt(1, employee.getEmpId());
					pst.setString(2, employee.getName());
					pst.setString(3, employee.getCity());
					pst.setDouble(4, employee.getSalary());
					return pst;
				}
			});
			
			return this.findEmpById(employee.getEmpId());
		}

	}

	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

}
