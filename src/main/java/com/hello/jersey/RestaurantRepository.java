package com.hello.jersey;

import java.sql.*;
import java.util.ArrayList;

public class RestaurantRepository {

    private DbConnector db = new DbConnector();

    public ArrayList<Restaurant> readRestaurant() {
        ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
        try {
            Connection con = db.getConnection();
            Statement smt = con.createStatement();
            String query = "select * from restaurants";
            ResultSet rs = smt.executeQuery(query);
            while(rs.next()){
                Restaurant r = new Restaurant();
                r.setId(rs.getInt(1));
                r.setName(rs.getString(2));
                r.setLocation(rs.getString(3));
                r.setCuisine(rs.getString(4));
                System.out.println(r);
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
            Connection con = db.getConnection();
            String query = "INSERT INTO public.restaurants(\n" +
                    "\tname, location, cuisine)\n" +
                    "\tVALUES (?, ?, ?);";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setString(1,r.getName());
            smt.setString(2,r.getLocation());
            smt.setString(3,r.getCuisine());
            rows = smt.executeUpdate();
            System.out.println("Records Inserted : "+rows);
        }catch (SQLException e){
            System.out.println("SQLException in createRestaurant :"+e.getMessage());
        }
        return rows;
    }

    public int updateRestaurant(Restaurant r) {
        int rows = 0;
        try {
            Connection con = db.getConnection();
            String query = "UPDATE public.restaurants SET\n" +
                    "\tname = ?, location = ?, cuisine = ?" +
                    "\tWHERE id = ?;";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setInt(4,r.getId());
            smt.setString(1,r.getName());
            smt.setString(2,r.getLocation());
            smt.setString(3,r.getCuisine());
            rows = smt.executeUpdate();
            System.out.println("Records Inserted : "+rows);
        }catch (SQLException e){
            System.out.println("SQLException in updateRestaurant :"+e.getMessage());
        }
        return rows;
    }

    public int deleteRestaurant(Restaurant r) {
        int rows = 0;
        try{
            Connection con = db.getConnection();
            String query = "DELETE FROM public.restaurants WHERE id = ?";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setInt(1,r.getId());
            rows = smt.executeUpdate();
        }catch (SQLException e){
            System.out.println("SQLException in deleteRestaurant :"+e.getMessage());
        }
        return rows;
    }
}
