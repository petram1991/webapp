package org.example.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

@Path("/helloworld")
public class HelloWorldResource {
    @GET
    public Response hello() {
        return Response
                .ok()
                .entity("Hello world!")
                .build();
    }

    @GET
    @Path("/query")
    public Response helloworlds(@QueryParam("n") String name){
        return Response
                .ok()
                .entity("Hello " + name + "!")
                .build();
    }

    @POST
    public Response postIets(String requestBody, @Context UriInfo uriInfo){
        String body = requestBody != null ? requestBody : "";
        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder().path("a_new_location");
        return Response
                .created(uriBuilder.build())
                .entity("hello world " + body)
                .build();
    }

}
