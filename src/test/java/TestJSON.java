import com.alibaba.fastjson.JSONObject;
import com.oraen.oxygen.common.util.JSON;
import com.oraen.oxygen.common.util.MapUtil;

import java.util.HashMap;
import java.util.Map;

public class TestJSON {

    public static void main(String[] args) {


    }

    public static void testJSONToEntity() throws NoSuchFieldException {
        JSONObject j = new JSONObject();
        j.put("asd", "dsa");
        j.put("asdc", 1.65);
        j.put("ak", 1.002110010);
        j.put("pk", 8);
        System.out.println(j.toString());
        Map<String, Object> map = JSON.parseMap(j.toString());
        System.out.println(map.toString());
        System.out.println(JSON.stringify(map));
        System.out.println(String.class);

        String.class.getField("toString");

    }
}
