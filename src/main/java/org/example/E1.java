package org.example;


import java.sql.*;

public class E1 {
    public static void main(String[] args) {

        //connect to database

                      //driver /name of db/address of ip//port no//database name
        String dbURL="jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String userName= "syntax_hrm";
        String password="syntaxhrm123";

        //driver manager used from java.sql. helps us establish the connection

        try {
            Connection connection =DriverManager.getConnection(dbURL,userName,password);
            //statement  is used as  driver
            Statement statement =connection.createStatement();
            String query ="select * from person";
            //result set is used for output in table format
            ResultSet resultSet=statement.executeQuery(query);

            while(resultSet.next()){
                String firstname=resultSet.getString("firstname");
                int age= resultSet.getInt("age");
                String city=resultSet.getString("city");
                System.out.println(firstname+" "+age+" "+city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    }
