package com.hello.jersey;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("restaurants/menus")
public class MenuService {

    private MenuRepository rr = new MenuRepository();

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ArrayList<Menu> readMenu(Restaurant restaurant){
        return rr.readMenu(restaurant);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response createMenu(Menu m){
        System.out.println(m);
        int rows =  rr.createMenu(m);
        return Response.status(200).entity("Rows Inserted : "+rows).build();
    }

    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateMenu(Menu m){
        int rows = rr.updateMenu(m);
        return Response.status(200).entity("Rows Inserted : "+rows).build();
    }

    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteMenu(Menu m){
        int rows = rr.deleteMenu(m);
        return Response.status(200).entity("Rows Inserted : "+rows).build();
    }
}
