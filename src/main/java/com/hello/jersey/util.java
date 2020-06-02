package com.hello.jersey;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class util {

    DbConnector db = new DbConnector();

    public int id_gen(String table) throws Exception{
        int id = 0;
        Connection con = db.getConnection();
        String query = "select max(id) from public."+table;
        Statement smt = con.createStatement();
        ResultSet rs = smt.executeQuery(query);
        while(rs.next()){
            id = rs.getInt(1);
        }
        return id;
    }

    public String checkNull(String check){
        if(check == null)
            return "";
        return check;
    }
}
