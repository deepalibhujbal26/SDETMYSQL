package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class E3 {

    public static void main(String[] args) {
        try (Connection connection=DriverManager.getConnection(Constants.DB_URL,Constants.USER_NAME,Constants.PASSWORD)) {
            Statement statement=connection.createStatement();
            String query ="select * from employee";
            ResultSet rs=statement.executeQuery(query);
            //resultmetadata give us the info about how many cols
            ResultSetMetaData rsmd= rs.getMetaData();
            //System.out.println(rsmd.getColumnCount());
            for (int i = 1; i <=rsmd.getColumnCount() ; i++) {
                System.out.print(rsmd.getColumnName(i)+" ");
            }

            List<Map<String,String>>tableData=new ArrayList<>();
            while (rs.next()){
                Map<String,String>rowMap=new HashMap<>(); //hashMap is fastest
                for (int i = 1; i <=rsmd.getColumnCount() ; i++) {
                    String key=rsmd.getColumnName(i);
                    String value=rs.getString(i);
                    rowMap.put(key,value);
                }
                tableData.add(rowMap);
            }
            System.out.println(tableData);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
