import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class TestGetFX<T1, T2> {



    public TestGetFX() {
        ParameterizedType parametclass = (ParameterizedType) this.getClass().getGenericSuperclass();
        Type[] actualTypeArguments = parametclass.getActualTypeArguments();
        System.out.println((Class<T1>) actualTypeArguments[0]);
        System.out.println((Class<T2>) actualTypeArguments[1]);
    }

    public static void main(String[] args) {
        new TestGetFX<String, TestMap>();
    }
}
