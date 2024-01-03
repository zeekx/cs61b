package flik;

import org.junit.Test;

import static org.junit.Assert.*;

public class FlikTest {

    @Test
    public void isSameNumber0() {
        int a = 0;
        int b = 0;
        assertTrue(Flik.isSameNumber(a, b));
    }

    @Test
    public void isSameNumberNeg127() {
        int a = -127;
        int b = -127;
        for (int i = -128; i < 128; i++) {
            assertTrue(Flik.isSameNumber(i, i));
        }

    }

    @Test
    public void isSameNumberNeg129() {
        int a = -129;
        int b = -129;
        assertTrue(Flik.isSameNumber(a, b));
    }

    @Test
    public void isSameNumber128() {
        int a = 128;
        int b = 128;
        assertTrue(Flik.isSameNumber(a, b));
    }
}