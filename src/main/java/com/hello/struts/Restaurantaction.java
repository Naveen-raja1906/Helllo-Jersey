package com.hello.struts;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hello.jersey.Restaurant;
import com.hello.jersey.RestaurantRepository;
import com.hello.jersey.util;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import java.util.ArrayList;

public class Restaurantaction extends MappingDispatchAction {

    ArrayList<Restaurant> r;
    RestaurantRepository rr = new RestaurantRepository();
    util u = new util();

    public ActionForward read(ActionMapping mapping, ActionForm form,
                              HttpServletRequest request, HttpServletResponse response){

        request.setAttribute("restaurants",rr.readRestaurant());
        return mapping.findForward("success");
    }
    public ActionForward create(ActionMapping mapping, ActionForm form,
                                HttpServletRequest request, HttpServletResponse response){
        Restaurant r = new Restaurant();
        r.setName(request.getParameter("name"));
        r.setLocation(request.getParameter("location"));
        r.setCuisine(request.getParameter("cuisine"));
        rr.createRestaurant(r);
        return mapping.findForward("success");
    }
    public ActionForward delete(ActionMapping mapping, ActionForm form,
                                HttpServletRequest request, HttpServletResponse response){
        Restaurant r = new Restaurant();
        r.setId(Integer.parseInt(request.getParameter("strId")));
        rr.deleteRestaurant(r);
        return mapping.findForward("success");
    }
    public ActionForward edit(ActionMapping mapping, ActionForm form,
                              HttpServletRequest request, HttpServletResponse response){
        Restaurant r = new Restaurant();
        r.setId(Integer.parseInt(u.checkNull(request.getParameter("strId"))==""?"0":u.checkNull(request.getParameter("strId"))));
        r.setName(u.checkNull(request.getParameter("name")));
        r.setLocation(u.checkNull(request.getParameter("location")));
        r.setCuisine(u.checkNull(request.getParameter("cuisine")));
        rr.updateRestaurant(r);
        return mapping.findForward("success");
    }
}