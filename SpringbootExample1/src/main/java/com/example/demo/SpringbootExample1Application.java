package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class SpringbootExample1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext cfx=	SpringApplication.run(SpringbootExample1Application.class, args);
		Alien a=cfx.getBean(Alien.class);
		a.show();
		Alien a1=cfx.getBean(Alien.class);
		a1.show();
		
		/*
		 * ScopeAnotation b=cfx.getBean(ScopeAnotation.class); b.show(); ScopeAnotation
		 * c=cfx.getBean(ScopeAnotation.class); b.show();
		 */
		//System.out.println("welcome Sprin boot application");
	}

	

}
