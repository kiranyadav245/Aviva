package com.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class CXFRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		from("cxfrs:bean:cxfService").process(new Processor() {
			
			public void process(Exchange exchange) throws Exception {
				System.out.println(exchange.getIn().toString());
				
			}
		}).setBody(constant(new vo("murari")));
	}

}
class vo{
	String name;

	public vo(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}