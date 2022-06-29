package com.adams.JUsers.Controllers;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ControllerMVC implements WebMvcConfigurer {

	public void addViewControllers(ViewControllerRegistry registry) {// Faz o mapeamento das Views para as páginas
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/login").setViewName("login");
//		registry.addViewController("/delalt").setViewName("delalt");
//		registry.addViewController("/visualizar").setViewName("visualizar");
//		
	}

}