package ch6;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArraySetTest {

    private ArraySet<Integer> aSet;
    @Before
    public void setUp() throws Exception {
        this.aSet = new ArraySet<>();
    }

    @Test
    public void of() {
        aSet.add(1);
        aSet.add(2);
        aSet.add(3);
        ArraySet<Integer> anotherSet = ArraySet.of(1, 2, 3);
        assertEquals(aSet, anotherSet);
    }
    @Test
    public void equals() {
        ArraySet<String> aSet = new ArraySet<>();
        ArraySet<String> anotherSet = new ArraySet<>();

        aSet.add("Hello");
        aSet.add("world");

        anotherSet.add("Hello");
        anotherSet.add("world");

        boolean aeb = anotherSet.equals(aSet);
        boolean beq = aSet.equals(anotherSet);
        assertTrue( aeb && beq);
    }
    @Test
    public void equalsReflexive() {
        ArraySet<String> s1 = new ArraySet<>();
        assertTrue(s1.equals(s1));
        s1.add("x");
        assertTrue(s1.equals(s1));
    }
    @Test
    public void equalsTransitive() {
        ArraySet<String> s1 = new ArraySet<>();
        ArraySet<String> s2 = new ArraySet<>();
        ArraySet<String> s3 = new ArraySet<>();

        s1.add("Hello");
        s1.add("world");

        s2.add("Hello");
        s2.add("world");

        s3.add("Hello");
        s3.add("world");

        boolean aeb = s2.equals(s1);
        boolean bea = s1.equals(s2);
        boolean bec = s2.equals(s3);
        boolean aec = s1.equals(s3);
        assertTrue( aeb && bea && bec && aec);
    }

    @Test
    public void equalsNull() {
        ArraySet<String> aSet = new ArraySet<>();
        assertFalse(aSet.equals(null));
    }


    @Test
    public void contains() {
        this.aSet.add(3);
        assertTrue(aSet.contains(3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addNull() {
        aSet.add(null);
    }
    @Test
    public void add() {
        aSet.add(3);
        assertEquals(1, aSet.size());
    }

    @Test
    public void size() {
        assertEquals(0, aSet.size());
        aSet.add(3);
        assertEquals(1, aSet.size());
    }

}