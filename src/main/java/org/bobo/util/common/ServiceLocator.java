package org.bobo.util.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceLocator {
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:config/spring/spring-application.xml");;
	
	public ServiceLocator(){
	}
	public static Object lookup(String name){
		Object obj = ctx.getBean(name);
		if(obj == null){
		}
		return obj;
	}
}