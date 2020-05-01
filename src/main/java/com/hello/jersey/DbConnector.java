package com.hello.jersey;

import java.net.URISyntaxException;
import java.sql.*;

public class DbConnector {

    public Connection getConnection() throws SQLException{
        String url = "jdbc:postgresql://localhost:5432/jerseyApp";
        String user = "postgres";
        String pass = "password";
        try{
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e){
            System.out.println("ClassNotFoundException occured in getConnection :"+e.getMessage());
        }
        Connection con = DriverManager.getConnection(url,user,pass);
        return con;
    }
    /*public static void main(String[] args) {
        try {
            DbConnector db = new DbConnector();
            Connection connection = db.getConnection();
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("INSERT INTO test(word) VALUES('My cool Item');");
            ResultSet rs = stmt.executeQuery("SELECT word FROM test");
            while (rs.next()) {
                System.out.println("Thing: " + rs.getString("word"));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
}
