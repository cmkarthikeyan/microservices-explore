package com.cmk.micro.services.employee.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cmk.micro.services.employee.dao.model.Employee;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long>{

}
