package com.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class Main {

	public static void main(String[] args) throws Exception {
		FileRouter router = new FileRouter();
		CamelContext context = new DefaultCamelContext();
		
	try{
		context.addRoutes(router);
		context.start();
		Thread.sleep(5*60*1000);
	}catch (Exception e) {
		// TODO: handle exception
	}finally {
		context.stop();
	}
	
	}

}
