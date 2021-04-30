import com.oraen.oxygen.common.util.JSON;

import java.lang.reflect.Field;

public class TestType {
    public static void main(String[] args) {
//        Field[] fs = T1.class.getDeclaredFields();
//
//        for(Field f : fs){
//            System.out.println(f.getName());
//        }
//        JSON()
        T1 t = new T1(1, "dsa", 5);
        String s = JSON.stringify(t);
        System.out.println(s);
    }
}

class T1{
    private int asd;
    private String a;
    public  int md;

    public T1(int asd, String a, int md) {
        this.asd = asd;
        this.a = a;
        this.md = md;
    }
}
