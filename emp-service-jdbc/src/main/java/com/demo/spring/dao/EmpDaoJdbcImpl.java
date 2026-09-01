package com.demo.spring.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.demo.spring.entities.Employee;

@Repository
public class EmpDaoJdbcImpl implements EmpDao {

	@Override
	public List<Employee> findAllEmps() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Employee> findEmpById(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Employee save(Employee employee) {
		// TODO Auto-generated method stub
		return null;
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
