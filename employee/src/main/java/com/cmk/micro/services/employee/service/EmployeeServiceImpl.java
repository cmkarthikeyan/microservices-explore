package com.cmk.micro.services.employee.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmk.micro.services.employee.dao.EmployeeRepository;
import com.cmk.micro.services.employee.dto.EmployeeDTO;
import com.cmk.micro.services.employee.service.exception.EmployeeNotFoundException;
import com.cmk.micro.services.employee.service.mapper.EmployeeMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	EmployeeMapper employeeMapper;

	@Override
	public List<EmployeeDTO> getEmployees() {
		log.info("All employees data loaded");

		List<EmployeeDTO> employees = new ArrayList<>();

		employeeRepository.findAll().forEach(employee -> {
			EmployeeDTO employeeDTO = employeeMapper.getDTOfromEntity(employee);
			employees.add(employeeDTO);
		});
		return employees;
	}

	@Override
	public EmployeeDTO getEmployee(Long id) {
		return employeeMapper.getDTOfromEntity(employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("No Employee details found for the id :" + id)));
	}

	@Override
	public void createEmployee() {
		// TODO Auto-generated method stub

	}

}
