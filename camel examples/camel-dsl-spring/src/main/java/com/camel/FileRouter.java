package com.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

import com.camel.error.MyRouterEception;

public class FileRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		//router level exception
		//if .handled(true) is not added, error will be keep on throwing.
				onException(MyRouterEception.class).process(new Processor() {
					
					public void process(Exchange arg0) throws Exception {
						System.out.println("this is router level exception handling");
						
					}
				}).onRedelivery(new Processor() {
					
					public void process(Exchange arg0) throws Exception {
						System.out.println(arg0);
						arg0.getIn().setBody("test");
						
					}
				}).redeliveryPolicyRef("testRedelivery").log("received body ${body}").handled(true);
		
		//handling with dotry() docatch blocks
		/*from("file:e:/input?noop=true").doTry().process(new SimpleProcessor()).doCatch(MyRouterEception.class)
				.process(new Processor() {

					public void process(Exchange arg0) throws Exception {
						System.out.println("exception caught");

					}
				}).to("file:e:/output");*/
		
		
		from("file:e:/output?noop=true").process(new SimpleProcessor()).to("file:e:/output");
		from("file:e:/hf?noop=true").process(new SimpleProcessor()).to("file:e:/output");
	}

}
