import com.oraen.oxygen.common.util.RandomUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TestRand {

    public static void main(String[] args) {
//        Random random = new Random();
//        random.nextInt(9);
//        int i=100;
//        while(i > 0){
//            i--;
//            System.out.println(random.nextInt(9));
//        }
//        System.out.println(Double.MIN_VALUE > Integer.MIN_VALUE);
//        System.out.println(Double.NaN);
//        double a = Double.NaN;
//        double b = a-10;
//        System.out.println(b);
//        System.out.println(new Random().nextInt(0));
//        System.out.println(new Random().nextInt(0));
//        System.out.println(new Random().nextInt(0));
//        System.out.println(new Random().nextInt(0));
//        System.out.println(new Random().nextInt(1));
//        System.out.println(new Random().nextInt(1));
//        int[] a = {0,0,0,0,0,0,0,0};
//
//        for(int i=0; i<10000; i++){
//            int r = RandomUtil.getRandomNum(1, 1);
//            a[r] ++;
//        }
//
//        for(int k :a){
//            System.out.println(k);
//        }
//        int a[] = {0,0};
//        double rate = 0.378;
//
//        for(int i=0; i<10000000; i++){
//            if(RandomUtil.rate(rate)){
//                a[0] ++;
//            }else{
//                a[1]++;
//            }
//        }
//
//        System.out.println(a[0]);
//        System.out.println(a[1]);
//        System.out.println((double)a[0] / (a[1] + a[0]));

        testRan();





    }

    public static void testRan(){
        Map<String, Double> m = new HashMap<>();
        m.put("aa", 15.0);
        m.put("bb", 25.0);
        m.put("cc", 15.0);
        m.put("dd", 15.0);
        m.put("ee", 30.0);

        Map<String, Integer> ge = new HashMap<>();
        ge.put("aa", 0);
        ge.put("bb", 0);
        ge.put("cc", 0);
        ge.put("dd", 0);
        ge.put("ee", 0);

        for(int i=0; i<100000000; i++){
            String v = RandomUtil.getRandom(m);
            ge.put(v, ge.get(v) + 1);
        }

        for(Map.Entry<String, Integer> en : ge.entrySet()){
            System.out.println(en.getKey() +"............" + en.getValue() + ".........偏差 " + (en.getValue()-m.get(en.getKey())*1000000) );
        }


    }
}
