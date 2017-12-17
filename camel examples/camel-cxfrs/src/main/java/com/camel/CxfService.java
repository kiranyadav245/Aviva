package com.camel;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/cxf")
public class CxfService {
	@GET
	@Path("/hi/{name}")
	@Produces(MediaType.APPLICATION_XML)
	public Vo sayHello(@PathParam("name")String name){
		return new Vo(name);
	}
	@GET
	@Path("/hello")
	public String sayHello(){
		return "kiran";
	}

}
