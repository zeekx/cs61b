package ch7;

import ch7.universe.BlackHole;
//import ch7.universe.HasHair;

import static ch7.universe.CreationUtils.hirsute;

public class Client {
    void demoAccess() {
        BlackHole b = hirsute();
        b.add("horse");
//        b.get(0);
//        HasHair hb = (HasHair) b;
    }
}