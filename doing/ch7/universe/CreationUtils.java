package ch7.universe;


public class CreationUtils {
    public static BlackHole hirsute() {
        return new HasHair();
    }
}


class HasHair implements BlackHole {
    
    Object[] items;
    public void add(Object o) { }
    public Object get(int k) {
        return null;
    }
}
