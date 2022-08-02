package com.jcg.hybernate.maven;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class DatabseUtill {
	static Session sessionObj;
	static SessionFactory sessionFactoryObj;
	static SessionFactory buildSessionFactory() {
		Configuration configObj=new Configuration();
		 configObj.configure("hibernate.cfg.xml");
		  ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();
		  sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
		  return sessionFactoryObj;
	}
}
