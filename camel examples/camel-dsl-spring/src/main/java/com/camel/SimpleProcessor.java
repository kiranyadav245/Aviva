package com.camel;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.camel.error.MyRouterEception;

public class SimpleProcessor implements Processor {

	public void process(Exchange arg0) throws Exception {
		System.out.println("in simple processor and the exchange is "+arg0);
		String body = arg0.getIn().getBody(String.class);
		System.out.println(body);
		if(body.contains("."))
		throw new MyRouterEception();
		
	}

}
