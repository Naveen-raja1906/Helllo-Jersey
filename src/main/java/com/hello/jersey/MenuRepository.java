package com.hello.jersey;

import java.sql.*;
import java.util.ArrayList;

public class MenuRepository {

    private DbConnector db = new DbConnector();

    public ArrayList<Menu> readMenu(Restaurant r) {
        ArrayList<Menu> items = new ArrayList<Menu>();
        try {
            Connection con = db.getConnection();
            String query = "select * from menu where restaurantid = ?";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setInt(1,r.getId());
            ResultSet rs = smt.executeQuery();
            while(rs.next()){
                Menu m = new Menu();
                m.setId(rs.getInt(1));
                m.setFoodname(rs.getString(2));
                m.setPrice(rs.getFloat(3));
                items.add(m);
            }
        }catch (SQLException e){
            System.out.println("SQLException in readMenu :"+e.getMessage());
        }
        return items;
    }

    public int createMenu(Menu m) {
        int rows = 0;
        try {
            Connection con = db.getConnection();
            String query = "INSERT INTO public.menu(\n" +
                    "\titemname, price, restaurantid)\n" +
                    "\tVALUES (?, ?, ?);";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setString(1,m.getFoodname());
            smt.setFloat(2,m.getPrice());
            smt.setInt(3,m.getRestaurantid());
            rows = smt.executeUpdate();
            System.out.println("Records Inserted : "+rows);
        }catch (SQLException e){
            System.out.println("SQLException in createMenu :"+e.getMessage());
        }
        return rows;
    }

    public int updateMenu(Menu m) {
        int rows = 0;
        try {
            Connection con = db.getConnection();
            String query = "UPDATE public.menu SET \n" +
                    "\tname = ?, price - ?, restaurantid = ?;";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setString(1,m.getFoodname());
            smt.setFloat(2,m.getPrice());
            smt.setInt(3,m.getRestaurantid());

            rows = smt.executeUpdate();
            System.out.println("Records Inserted : "+rows);
        }catch (SQLException e){
            System.out.println("SQLException in updateMenu :"+e.getMessage());
        }
        return rows;
    }

    public int deleteMenu(Menu m) {
        int rows = 0;
        try {
            Connection con = db.getConnection();
            String query = "DELETE FROM public.menu WHERE id = ?";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setInt(1,m.getId());
            rows = smt.executeUpdate();
        }catch (SQLException e){
            System.out.println("SQLException in deleteMenu :"+e.getMessage());
        }
        return rows;
    }
}
