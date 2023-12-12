package ReviewClass;

import org.example.DBUtils;

public class E2 {
    public static void main(String[] args) {
        //when datatype grows we can simply write var  instead of Map<>
        var data = DBUtils.fetch("select * from employee "); // we can change the query
        //its list if want the data of first row we can used get (zero)index
        System.out.println(data.get(0));
        //   System.out.println(data);

        //only we want salary
        System.out.println(data.get(0).get("salary"));

    }
}
