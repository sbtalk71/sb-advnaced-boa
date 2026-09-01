package com.demo.spring;

import com.demo.spring.controllers.EmpController;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.entities.Employee;

@Service
public class EmpService {


private EmpDao empDao;
	
	public EmpService(EmpDao empDao) {
		this.empDao = empDao;
		
	}
	
	public List<Employee> getEmpList(){
		return empDao.findAllEmps();
	}
	
	public Employee findEmp(Integer id) {
		return empDao.findEmpById(id);
	}
	
	
	public Employee saveEmp(Employee employee) {
		return empDao.save(employee);
	}
}
