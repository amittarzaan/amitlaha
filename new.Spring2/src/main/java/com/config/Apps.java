package com.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Apps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext apcnx=new AnnotationConfigApplicationContext(AppConfig.class);
		Samsung sm=apcnx.getBean(Samsung.class);
		sm.config();
	}

}
