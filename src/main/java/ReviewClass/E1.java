package ReviewClass;

import org.example.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class E1 {

    public static void main(String[] args) {

        List<Map<String, String>> tableDataList = new ArrayList<>();
        //it called as try with resources
        //when we done working with connection.close the connection
        //if not do  not close connection ,then it will cost us more.and keep it  busy (Eg Phone )
        try (Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.USER_NAME, Constants.PASSWORD)) {

            //it will work as truck .take the query and execute.
            Statement statement = connection.createStatement();
            //here we can add any query
            String query = "select * from person ";

            //result set contains output of query
            ResultSet rs = statement.executeQuery(query);
            //metadata is contains information about output for eg : how many columns
            ResultSetMetaData rsmd = rs.getMetaData();

            while (rs.next()) {
                Map<String, String> rowData = new HashMap<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    String key = rsmd.getColumnName(i);
                    String value = rs.getString(i);
                    rowData.put(key, value);
                }
                tableDataList.add(rowData);
            }
            System.out.println(tableDataList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
