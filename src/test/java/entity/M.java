package entity;

public class M{
    String a;
    String b;
    Float c;

    public M(String a, String b, Float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public M(){

    }

    @Override
    public String toString() {
        return "M{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c=" + c +
                '}';
    }
}