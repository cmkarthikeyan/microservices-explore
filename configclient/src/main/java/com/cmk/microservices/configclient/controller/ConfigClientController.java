package com.cmk.microservices.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {
   
	@Value("${test.message}")
	private String msg;

	@GetMapping("/")
	public String getCountry() {
		return msg;
	}
	
}
