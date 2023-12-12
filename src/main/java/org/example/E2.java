package org.example;


import java.sql.*;

public class E2 {
    public static void main(String[] args) {
        /*
        result contains the actual data
        ResultSetMetaData information about data
        ResultSet represents the actual data retrieved from the database,
        the ResultSetMetaData provides information about the structure of that data, such as the number and types of columns.
         */
     try(Connection connection=DriverManager.getConnection(Constants.DB_URL,Constants.USER_NAME,Constants.PASSWORD)){
         Statement statement= connection.createStatement();
         String query="Select * from person ";
         //resultset contains all rows ccols
         ResultSet resultSet=statement.executeQuery(query);
         //how many data entries has been fetch , how many cols can been fetch using metadata
         ResultSetMetaData resultSetMetaData= resultSet.getMetaData();
         System.out.println(resultSetMetaData.getColumnCount());
         //i always starts with 1  ! not with zero
         for (int i = 1; i <resultSetMetaData.getColumnCount() ; i++) {
             System.out.print(resultSetMetaData.getColumnName(i)+" ");
         }
         System.out.println();
         while (resultSet.next()){
             for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                 System.out.print(resultSet.getString(i)+" ");
             }
             System.out.println();
         }
     }catch(SQLException e){
         e.printStackTrace();
     }

    }
    }
