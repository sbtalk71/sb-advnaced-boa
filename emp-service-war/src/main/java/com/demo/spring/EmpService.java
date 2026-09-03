package com.demo.spring;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.demo.spring.entities.Employee;
import com.demo.spring.exceptions.EmployeeNotFoundException;
import com.demo.spring.jms.EmployeeMessageService;

@Service
public class EmpService {

	private EmpRepository empRepository;
private EmployeeMessageService employeeMessageService;
	public EmpService(EmpRepository empRepository,EmployeeMessageService employeeMessageService) {
		this.empRepository = empRepository;
		this.employeeMessageService=employeeMessageService;

	}

	@Cacheable(value = "employees")
	public List<Employee> getEmpList() {
		return empRepository.findAll();
	}

   @Cacheable(value="employee",key="#id")
	public Employee findEmp(Integer id) {

		Optional<Employee> empOp = empRepository.findById(id);
		if (empOp.isPresent()) {
			Employee emp=empOp.get();
			employeeMessageService.send(emp);
			return emp;
		} else {
			throw new EmployeeNotFoundException("Emp does not exist");
		}
	}

   @CachePut(value="employee", key="#employee.empId")
	public Employee saveEmp(Employee employee) {
		return empRepository.save(employee);
	}

   @CachePut(value="employee", key="#employee.empId")
	public Employee update(Employee employee) {
		if (empRepository.existsById(employee.getEmpId())) {
			return empRepository.save(employee);
		} else {
			throw new EmployeeNotFoundException("Emp does not exist");
		}
	}
   
   @CacheEvict(value="employee",key = "#id")
   public String delete(Integer id) {
	   if(empRepository.existsById(id)) {
		   empRepository.deleteById(id);
		   return "Emp deleted";
	   }else {
		   throw new EmployeeNotFoundException("Emp not found");
	   }
   }
}
