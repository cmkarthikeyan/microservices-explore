package com.cmk.micro.services.employee.service;

import java.util.List;

import com.cmk.micro.services.employee.dao.model.Employee;
import org.springframework.stereotype.Service;

import com.cmk.micro.services.employee.dto.EmployeeDTO;
import com.cmk.micro.services.employee.service.exception.EmployeeNotFoundException;

@Service
public interface EmployeeService {

	List<EmployeeDTO> getEmployees();

	EmployeeDTO getEmployee(Long id) throws EmployeeNotFoundException;

	EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
	
	EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO);
	
	void deleteEmployee(Long id) throws EmployeeNotFoundException;

}
