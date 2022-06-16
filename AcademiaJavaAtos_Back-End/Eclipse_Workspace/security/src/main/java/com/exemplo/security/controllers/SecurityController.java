package com.exemplo.security.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {
	@RequestMapping("/")
	public String HelloWorld() {
		return "Hello World";
	}
	

}
