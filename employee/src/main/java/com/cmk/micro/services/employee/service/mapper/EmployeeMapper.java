package com.cmk.micro.services.employee.service.mapper;

import org.mapstruct.Mapper;


import com.cmk.micro.services.employee.dao.model.Employee;
import com.cmk.micro.services.employee.dto.EmployeeDTO;

@Mapper
public interface EmployeeMapper {
	EmployeeDTO getDTOfromEntity(Employee employee);

	Employee getEntityFromDTO(EmployeeDTO employeeDTO);

}
