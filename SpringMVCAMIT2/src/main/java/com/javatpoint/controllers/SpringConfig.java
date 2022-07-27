package com.javatpoint.controllers;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configurable
@ComponentScan(basePackages = "com.javatpoint.controllers")
public class SpringConfig {
	
	@Bean
	public InternalResourceViewResolver viewResolve() {
		InternalResourceViewResolver vr=new InternalResourceViewResolver();
		vr.setPrefix("/WEB-INF/view/");
		vr.setSuffix(".jsp");
		return vr;
	}

}
