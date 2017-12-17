package com.camel;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class Main {
	public static void main(String[] args) throws Exception {
		CamelContext ctx = new DefaultCamelContext();
		ctx.addRoutes(new ActiveMqRouter());
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://0.0.0.0:61616");
        ctx.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
        
		ctx.start();
		Thread.sleep(5 * 60 * 1000);
        ctx.stop();
	}
}
