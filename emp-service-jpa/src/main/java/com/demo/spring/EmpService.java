package com.demo.spring;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.spring.entities.Employee;
import com.demo.spring.exceptions.EmployeeNotFoundException;

@Service
public class EmpService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	private EmpRepository empRepository;

	public EmpService(EmpRepository empRepository) {
		this.empRepository = empRepository;
		logger.info("injected repository object {}", empRepository.getClass().getName());
	}

	@Cacheable(value = "employees")
	@Transactional
	public List<Employee> getEmpList() {
		logger.info("fetching employee list from database");
		return empRepository.findAll();
		//return empRepository.listAllEmps();
	}

	@Cacheable(value = "employee", key = "#id")
	public Employee findEmp(Integer id) {
		logger.info("executing query for id {}",id);
		Optional<Employee> empOp = empRepository.findById(id);
		//Optional<Employee> empOp=empRepository.findOneEmp(id);
		if (empOp.isPresent()) {
			logger.info("Got Employee with id {} from database",id);
			return empOp.get();
		} else {
			logger.info("EMployee not found, throwing exception {}", EmployeeNotFoundException.class.getName());
			throw new EmployeeNotFoundException("Emp does not exist");
		}
	}

	@CachePut(value = "employee", key = "#employee.empId")
	public Employee saveEmp(Employee employee) {
		return empRepository.save(employee);
	}

	@CachePut(value = "employee", key = "#employee.empId")
	public Employee update(Employee employee) {
		if (empRepository.existsById(employee.getEmpId())) {
			return empRepository.save(employee);
		} else {
			throw new EmployeeNotFoundException("Emp does not exist");
		}
	}

	@CacheEvict(value = "employee", key = "#id")
	public String delete(Integer id) {
		if (empRepository.existsById(id)) {
			empRepository.deleteById(id);
			return "Emp deleted";
		} else {
			throw new EmployeeNotFoundException("Emp not found");
		}
	}
	
	public List<Employee> getSortedEmpList() {
		logger.info("fetching sorted employee list from database");
		return empRepository.findAll(Sort.by("city").descending());
	}
	
	public List<Employee> getPagedEmpList(int start, int size) {
		logger.info("fetching paged employee list from database");
		
		Pageable pageable=PageRequest.of(start, size);
		Page<Employee> empPage=empRepository.findAll(pageable);
		
		return empPage.toList();
	}
}
