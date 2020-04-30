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
    @Path("/restaurant")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response createRestaurant(Restaurant r){
       int rows =  rr.createRestaurant(r);
       return Response.status(200).entity("Rows Inserted : "+rows).build();
    }

    @PUT
    @Path("/{restaurant}")
    @Produces(MediaType.TEXT_PLAIN)
    public void updateRestaurant(@PathParam("restaurant") String restaurant){
        rr.updateRestaurant(restaurant);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public void deleteRestaurant(@PathParam("id") int id){
        rr.deleteRestaurant(id);
    }
}
