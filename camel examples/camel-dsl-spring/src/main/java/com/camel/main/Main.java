package com.camel.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) throws Exception {
		AbstractApplicationContext context = new  ClassPathXmlApplicationContext("applicationContext-camel.xml");
		context.start();
		Thread.sleep(5*60*1000);
		context.stop();
		context.close();
	}

}
