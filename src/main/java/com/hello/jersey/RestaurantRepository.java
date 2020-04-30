package com.hello.jersey;

import java.sql.*;
import java.util.ArrayList;

public class RestaurantRepository {

    private DbConnector db;
    Connection con = db.getConnection();

    public ArrayList<Restaurant> readRestaurant() {
        ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
        try {
            Statement smt = con.createStatement();
            String query = "select * from restaurants";
            ResultSet rs = smt.executeQuery(query);
            while(rs.next()){
                Restaurant r = new Restaurant();
                r.setId(rs.getInt(1));
                r.setName(rs.getString(2));
                r.setLocation(rs.getString(3));
                r.setCuisine(rs.getString(4));

                restaurants.add(r);
            }
        }catch (SQLException e){
            System.out.println("SQLException in readRestaurant :"+e.getMessage());
        }
        return restaurants;
    }

    public int createRestaurant(Restaurant r) {
        int rows = 0;
        try {
            String query = "INSERT INTO public.restaurants(\n" +
                    "\tid, name, location, cuisine, menuid)\n" +
                    "\tVALUES (?, ?, ?, ?, ?);";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setInt(1,r.getId());
            smt.setString(2,r.getName());
            smt.setString(3,r.getLocation());
            smt.setString(4,r.getCuisine());
            smt.setInt(5,r.getMenuid());

            rows = smt.executeUpdate();
            System.out.println("Records Inserted : "+rows);
        }catch (SQLException e){
            System.out.println("SQLException in createRestaurant :"+e.getMessage());
        }
        return rows;
    }

    public void updateRestaurant(String id) {
        Connection con = db.getConnection();
    }

    public void deleteRestaurant(int id) {
        Connection con = db.getConnection();
    }
}
