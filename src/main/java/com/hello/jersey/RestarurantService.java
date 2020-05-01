package com.hello.jersey;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/restaurants")
public class RestarurantService {

    private RestaurantRepository rr = new RestaurantRepository();

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ArrayList<Restaurant> readRestaurant(){
        return rr.readRestaurant();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response createRestaurant(Restaurant r){
        System.out.println(r);
        int rows =  rr.createRestaurant(r);
        return Response.status(200).entity("Rows Inserted : "+rows).build();
    }

    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateRestaurant(Restaurant r){
        int rows = rr.updateRestaurant(r);
        return Response.status(200).entity("Rows Inserted : "+rows).build();
    }

    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteRestaurant(Restaurant r){
        int rows = rr.deleteRestaurant(r);
        return Response.status(200).entity("Rows Inserted : "+rows).build();
    }
}
