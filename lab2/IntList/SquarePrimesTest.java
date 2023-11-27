package IntList;

import static org.junit.Assert.*;
import org.junit.Test;

public class SquarePrimesTest {

    /**
     *
     */
    @Test
    public void testSquarePrimesNull() {
        IntList lst = IntList.of();
        boolean changed = IntListExercises.squarePrimes(lst);
        assertFalse("There isn't any numbers", changed);
    }

    @Test
    public void testSquarePrimes1() {
        IntList lst = IntList.of(1);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertFalse("'1' is NOT a prime, a prime should >= 1", changed);
    }

    @Test
    public void testSquarePrimes4() {
        IntList lst = IntList.of(4);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertFalse("4 is NOT a prime", changed);
    }

    @Test
    public void testSquarePrimesAnother() {
        IntList lst = IntList.of(1, 3, 5, 7, 11);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("1 -> 9 -> 25 -> 49 -> 121", lst.toString());
        assertTrue(changed);
    }
    /**
     * Here is a test for isPrime method. Try running it.
     * It passes, but the starter code implementation of isPrime
     * is broken. Write your own JUnit Test to try to uncover the bug!
     */
    @Test
    public void testSquarePrimesSimple() {
        IntList lst = IntList.of(14, 15, 16, 17, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 15 -> 16 -> 289 -> 18", lst.toString());
        assertTrue(changed);
    }
}
