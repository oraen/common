package entity;

import com.oraen.oxygen.common.base.box.CharBox;

public class TestCharBox {
    public static void main(String[] args) {
        CharBox cb = new CharBox("abcda");
        System.out.println(cb);
        System.out.println(cb.getSize());
        System.out.println("1");

        cb.add('c');
        System.out.println(cb);
        System.out.println(cb.getSize());  //ok
        System.out.println("2");

        cb.add(2,'b');
        System.out.println(cb);   //ok
        System.out.println(cb.getSize());  //ok
        System.out.println("3");

        cb.add(3,"bie");
        System.out.println(cb);  // ok
        System.out.println(cb.getSize());  //ok

        cb.add("zqr");
        System.out.println(cb);
        System.out.println(cb.getSize());  //ok

        System.out.println("...............................................");
        cb.pop();
        System.out.println(cb);

        cb.remove(2);
        System.out.println(cb);

        cb.remove(1, 4);
        System.out.println(cb);

        cb.set(1, '2');
        System.out.println(cb);

        cb.set(1, "789");
        System.out.println(cb);

        System.out.println(cb.get(-2));
    }
}
