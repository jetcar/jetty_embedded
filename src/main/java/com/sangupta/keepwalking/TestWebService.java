package com.sangupta.keepwalking;

import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Path("/api")
public class TestWebService {

    String url = "jdbc:postgresql://localhost:5432/dsg?user=postgres&password=qqqqqq";
    static Connection conn = null;
    public TestWebService()
    {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            if(conn == null || conn.isClosed())
                try {
                    conn = DriverManager.getConnection(url);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String available() throws SQLException {


        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM records WHERE userid = 'f6001b6c-a788-5d1f-b1a2-c42191496897'");

        List<Record> records=new ArrayList<Record>();

        while(rs.next()) {
            Record record = new Record();
            record.setUserid(rs.getString("UserId"));
            record.set_name(rs.getString("name"));
            record.set_time(rs.getString("time"));


            records.add(record);
        }
        Gson gson = new Gson();
        String json = gson.toJson(records);
        return json;
    }

}