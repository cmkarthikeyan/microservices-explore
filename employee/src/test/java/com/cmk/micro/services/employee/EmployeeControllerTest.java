package com.cmk.micro.services.employee;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.cmk.micro.services.employee.dao.model.Address;
import com.cmk.micro.services.employee.dto.EmployeeDTO;
import com.cmk.micro.services.employee.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
public class EmployeeControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	EmployeeService employeeService;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Test
	void testGetEmployees() throws Exception {
		mockMvc.perform(get("/api/v1/employees/").accept(MediaType.APPLICATION_JSON)).andExpect(status().is(200));
	}
	
	@Test
	void testPostEmployees() throws Exception {
		EmployeeDTO employee = EmployeeDTO.builder().name("testemployee").age(11).primaryAddress(Address.builder().city("Chennai").doorNumber(31).pincode(83).state("TN").build()).build();
		String requestBody = objectMapper.valueToTree(employee).toString();
		System.out.println("Employee creation input : " + requestBody);
		when(employeeService.createEmployee(employee)).thenReturn(employee);
		mockMvc.perform(post("/api/v1/employees/").content(requestBody).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().is(201));
	}
}
