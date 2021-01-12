package com.cmk.micro.services.employee.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.hateoas.EntityModel;

import com.cmk.micro.services.employee.dao.model.Address;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ExternalDocumentation(description = "This is employee object")
public class EmployeeDTO extends EntityModel<EmployeeDTO> {
	private long id;

	@Size(min = 4, message = "Name should be greater than 4 charecters")
	private String name;
	private int age;
	@NotNull(message = "Address should not be empty")
	private Address primaryAddress;
}
