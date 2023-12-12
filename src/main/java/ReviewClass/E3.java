package ReviewClass;

public class E3 {

    String n;

    void setData() {

        String name = "Ehab";
        n = name;
    }

    void getData() {
        System.out.println(n);
    }

    public static void main(String[] args) {
        E3 obj = new E3();
        obj.setData();
        obj.getData();

    }
}
