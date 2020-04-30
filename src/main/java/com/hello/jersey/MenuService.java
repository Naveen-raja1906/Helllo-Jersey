package com.hello.jersey;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("reataurants/menus")
public class MenuService {

    MenuRepository mr = new MenuRepository();

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ArrayList<Menues> readMenu(int id){
        return mr.readMenu(id);
    }

    @POST
    @Path("menu")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public int createMenu(Menues m){
        return mr.createMenu(m);
    }
}
