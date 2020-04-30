package com.hello.jersey;

import java.net.URISyntaxException;
import java.sql.*;

public class DbConnector {

    public Connection getConnection(){
        try{
            String url = "jdbc:postgresql://localhost:5432/jerseyApp";
            String user = "postgres";
            String pass = "password";
            Connection con = DriverManager.getConnection("url",user,pass);
            Class.forName("org.postgresql.Driver");
            return con;
        }catch (SQLException e){
            System.out.println("SQLException occured in getConnection :"+e.getMessage());
        }catch (ClassNotFoundException e){
            System.out.println("ClassNotFoundException occured in getConnection :"+e.getMessage());
        }
        return null;
    }
    /*public static void main(String[] args) {
        try {
            DbConnector db = new DbConnector();
            Connection connection = db.getConnection();
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("INSERT INTO GOODS(THING) VALUES('My cool Item');");
            ResultSet rs = stmt.executeQuery("SELECT Thing FROM Goods");
            while (rs.next()) {
                System.out.println("Thing: " + rs.getString("thing"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
}
