import com.alibaba.fastjson.JSONObject;
import com.oraen.oxygen.common.util.HttpUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestHttp {

    public static void main(String[] args) throws Exception {
   //     testGet();
        testPost();
   //     HttpUtil.sendPostUrl("http://172.24.17.57:17150/tb/dataServer/getItem", "sfc=asd&site=500");

    }


    public static void testGet() throws IOException {
        // System.out.println(request("http://baidu.com"));
        //      System.out.println(request("hTtPs://192.168.30.26:17150/tb/dataServer/getItem?sfc=EH534920903463&site=1001", HttpMethod.GET, 5000));

        //    System.out.println(get("192.168.30.26:17150/tb/dataServer/getItem?sfc=EH534920903463&site=1001", null));
        String url = "192.168.30.26:17150/tb/dataServer/getItem?";
        JSONObject a = new JSONObject();
        a.put("sfc", "EH534920903463");
        a.put("site", "1001");
        System.out.println(HttpUtil.get(url, a));

    }

    public static void testPost() throws IOException {
        String url = "172.24.17.57:17150/tb/dataServer/getItem";
        JSONObject a = new JSONObject();
        a.put("sfc", "EH534920903463");
        a.put("site", "1001");
        System.out.println(HttpUtil.post(url, a));

    }


}
