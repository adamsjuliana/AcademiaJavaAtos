package com.exemplo.security2.Controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ControllerMVC implements WebMvcConfigurer{
	public void addViewController (ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/ola").setViewName("ola");
		registry.addViewController("/login").setViewName("login");
		}
}
