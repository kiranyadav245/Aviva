package com.camel.router;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

import com.camel.Vo;
import com.camel.processor.CxfServiceProcessor;

public class CxfRouter extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("cxfrs://bean://restService").process(new Processor() {
			
			public void process(Exchange msg) throws Exception {
				String s = msg.getIn().getBody(String.class);
//				msg.getOut().setBody("Hello "+s+" welcome to camel with xf world");
				msg.getOut().setBody(new Vo(s));
				
			}
		});
		
		
		
	}

}
