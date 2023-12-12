package org.example;

import java.util.List;
import java.util.Map;

public class E4 {
    public static void main(String[] args) {
        List<Map<String,String>>data=DBUtils.fetch("select * from person " );
        System.out.println(data);

        //index fixed value is zero
        Map<String,String>rowData=data.get(0);
        System.out.println(rowData);

        System.out.println(rowData.get("FirstName"));
    }
}
