package com.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.camel.Vo;

public class CxfServiceProcessor implements Processor {

	public void process(Exchange msg) throws Exception {
		String s = msg.getIn().getBody(String.class);
//		msg.getOut().setBody("Hello "+s+" welcome to camel with xf world");
		msg.getOut().setBody(new Vo(s));
		
	}

}
