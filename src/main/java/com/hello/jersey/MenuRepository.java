package com.hello.jersey;

import java.sql.*;
import java.util.ArrayList;

public class MenuRepository {

    DbConnector db;
    Connection con = db.getConnection();
    public ArrayList<Menues> readMenu(int id) {
        ArrayList<Menues> items = new ArrayList<Menues>();
        try {
            Statement smt = con.createStatement();
            String query = "select * from menuItems";
            ResultSet rs = smt.executeQuery(query);
            while(rs.next()){
                Menues m = new Menues();
                m.setId(rs.getInt(1));
                m.setFoodname(rs.getString(2));
                m.setPrice(rs.getFloat(3));

                items.add(m);
            }
        }catch (SQLException e){
            System.out.println("SQLException in readRestaurant :"+e.getMessage());
        }
        return items;
    }

    public int createMenu(Menues m) {
        int rows = 0;
        try {
            String query = "INSERT INTO public.\"menuItems\"(\n" +
                    "\tid, name, price)\n" +
                    "\tVALUES (?, ?, ?);";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setInt(1,m.getId());
            smt.setString(2,m.getFoodname());
            smt.setFloat(3,m.getPrice());

            rows = smt.executeUpdate();
            System.out.println("Records Inserted : "+rows);
        }catch (SQLException e){
            System.out.println("SQLException in createRestaurant :"+e.getMessage());
        }
        return rows;
    }
}
