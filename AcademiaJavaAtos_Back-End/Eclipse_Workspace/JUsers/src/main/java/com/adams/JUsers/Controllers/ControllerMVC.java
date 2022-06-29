package com.adams.JUsers.Controllers;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ControllerMVC implements WebMvcConfigurer {

	public void addViewControllers(ViewControllerRegistry registry) {// Faz o mapeamento das Views para as páginas
		registry.addViewController("/jusers").setViewName("home");
		registry.addViewController("/jusers/login").setViewName("login");
		registry.addViewController("/jusers/visualizaradmin").setViewName("visualizaradmin");
		registry.addViewController("/jusers/editar").setViewName("editar");
		registry.addViewController("/jusers/cadastrar").setViewName("cadastrar");
	}

}