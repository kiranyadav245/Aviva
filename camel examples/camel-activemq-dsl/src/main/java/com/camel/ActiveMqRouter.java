package com.camel;

import org.apache.camel.builder.RouteBuilder;

public class ActiveMqRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:e:/input?noop=true").split().tokenize("\n").to("jms:queue:filecontentmq");
	}

}
