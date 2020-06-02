package com.hello.struts;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Null;

import com.hello.jersey.Menu;
import com.hello.jersey.MenuRepository;
import com.hello.jersey.Restaurant;
import com.hello.jersey.util;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import java.util.ArrayList;

public class Menuaction extends MappingDispatchAction {

    ArrayList<Menu> m;
    util u = new util();
    MenuRepository mr = new MenuRepository();
    private int restaurantId;

    public ActionForward read(ActionMapping mapping, ActionForm form,
                              HttpServletRequest request, HttpServletResponse response){
        Restaurant r = new Restaurant();
        String id = request.getParameter("strId");
        System.out.println(id);
        if(id != null){
            r.setId(Integer.parseInt(id));
            this.restaurantId = r.getId();
        }else{
            r.setId(this.restaurantId);
        }
        request.setAttribute("menus",mr.readMenu(r));
        return mapping.findForward("success");
    }
    /*public ActionForward display(ActionMapping mapping, ActionForm form,
                              HttpServletResponse response, HttpServletRequest request){
        Restaurant r = new Restaurant();
        r.setId(this.restaurantId);
        request.setAttribute("menus", mr.readMenu(r));
        return mapping.findForward("success");
    }*/
    public ActionForward create(ActionMapping mapping, ActionForm form,
                                HttpServletRequest request, HttpServletResponse response){
        Menu m = new Menu();
        m.setFoodname(request.getParameter("foodname"));
        m.setPrice(Float.parseFloat(request.getParameter("strPrice")));
        m.setRestaurantid(this.restaurantId);
        mr.createMenu(m);
        return mapping.findForward("success");
    }
    public ActionForward delete(ActionMapping mapping, ActionForm form,
                                HttpServletRequest request, HttpServletResponse response){
        Menu m = new Menu();
        m.setId(Integer.parseInt(request.getParameter("strId")));
        mr.deleteMenu(m);
        return mapping.findForward("success");
    }
    public ActionForward edit(ActionMapping mapping, ActionForm form,
                              HttpServletRequest request, HttpServletResponse response){
        Menu m = new Menu();
        m.setId(Integer.parseInt(u.checkNull(request.getParameter("strId"))==""?"0":u.checkNull(request.getParameter("strId"))));
        m.setFoodname(u.checkNull(request.getParameter("foodname")));
        m.setPrice(Float.parseFloat(u.checkNull(request.getParameter("strPrice"))==""?"0":u.checkNull(request.getParameter("strPrice"))));
        mr.updateMenu(m);
        return mapping.findForward("success");
    }
}