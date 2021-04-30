import com.oraen.oxygen.common.util.JSON;
import com.oraen.oxygen.common.util.MapUtil;
import com.oraen.oxygen.common.util.TestUtil;
import entity.M;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestMap {

    public static void main(String[] args) throws Exception {
      //  testKeySet();
        testMapToE();
  //      testClassGX();
    }


    public static void testKeySet() {
        Map<String, String> a = new HashMap<>();
        a.put("asd", "c");
        Set<String> s = a.keySet();
        System.out.println(s.contains("asd")); //true
        System.out.println(a.get("asd")); //c
        s.remove("asd");
     //   s.add("asdf"); 抛出异常
        System.out.println(a.get("asd")); //?   ---
        System.out.println(a.get("asdf")); //?   ---

    }

    public static void testMapToE() throws NoSuchFieldException, IllegalAccessException {
        Map<String, Object> map = new HashMap<>();
        map.put("a", "asd");
        map.put("b", "123");
        map.put("c", 4574.65454);

        M m = MapUtil.createEntity(map, M.class);
        TestUtil.log(JSON.stringify(m));

    }

    public static void testClassGX() {
    //    System.out.println(String.class.isInstance("...."));  //true
    //    System.out.println(Object.class.isInstance("...."));
        System.out.println(Integer.class.isInstance("...."));  //false

    }
}


