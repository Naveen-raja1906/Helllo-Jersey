package com.hello.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloService {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getMessage(){
        System.out.println("in get");
        return "<h1>Hello World!!!</h1>";
    }
}
