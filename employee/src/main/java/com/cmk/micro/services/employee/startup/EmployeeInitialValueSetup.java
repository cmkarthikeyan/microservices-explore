package com.cmk.micro.services.employee.startup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cmk.micro.services.employee.dao.AddressRepository;
import com.cmk.micro.services.employee.dao.EmployeeRepository;
import com.cmk.micro.services.employee.dao.model.Address;
import com.cmk.micro.services.employee.dao.model.Employee;

@Component
public class EmployeeInitialValueSetup  implements CommandLineRunner{
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	AddressRepository addressRepository;

	@Override
	public void run(String... args) throws Exception {
		Address cmkAddress = Address.builder().doorNumber(7).city("trichy").state("TN").pincode(600073).build();
		Address omAddress = Address.builder().doorNumber(10).city("chennai").state("TN").pincode(600122).build();
		
		Employee cmk = Employee.builder().name("CMK").age(30).build();
		Employee om = Employee.builder().name("OM").age(28).build();
		
		cmk.setPrimaryAddress(cmkAddress);
		om.setPrimaryAddress(omAddress);
		
		employeeRepository.save(cmk);
		employeeRepository.save(om);
	}

}
