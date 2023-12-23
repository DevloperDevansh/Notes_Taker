package com.helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryProvider {
	
	//make Sessionfactory variable
	public static SessionFactory factory;
	
	
	//function to get factory 
	public static  SessionFactory getFactory() {
		
		if(factory==null) {
			factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}
		
		return factory;
	}
	
	
   //function to get close
	public void closeFactory() {
		if(factory.isOpen()) {
			factory.close();
		}
	}

}
