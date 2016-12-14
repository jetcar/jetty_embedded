package com.sangupta.keepwalking;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api")
public class TestWebService {

    public TestWebService()
    {

    }

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public static String available() {
        return "yes";
    }

}