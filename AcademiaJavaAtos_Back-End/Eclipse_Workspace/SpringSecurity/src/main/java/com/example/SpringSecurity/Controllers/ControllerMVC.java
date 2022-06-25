package com.example.SpringSecurity.Controllers;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ControllerMVC implements WebMvcConfigurer {

	public void addViewControllers(ViewControllerRegistry registry) {// Faz o mapeamento das Views para as páginas
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/hello").setViewName("hello");
		registry.addViewController("/login").setViewName("login");
	}

}