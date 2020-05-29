package com.ibm.patient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/*import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
*/
@SpringBootApplication
 @RestController
public class PatientApplication  extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PatientApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(PatientApplication.class, args);
			}
			
			  @GetMapping("/hello") public String hello(@RequestParam(value = "name",
			  defaultValue = "World1.18/5/2020") String name) { return
			  String.format("Hello %s!", name); }
			 			
				
				  @Bean public InternalResourceViewResolver jspViewResolver() {
				  InternalResourceViewResolver resolver= new InternalResourceViewResolver();
				  resolver.setPrefix("/WEB-INF/jsp/"); resolver.setSuffix(".jsp"); return
				  resolver; }
				 
				 


}
