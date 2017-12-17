package com.camel;

import org.apache.camel.builder.RouteBuilder;

public class FileRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:e:/input?noop=true").to("file:e:/output").log("file transfered");
	}

}
