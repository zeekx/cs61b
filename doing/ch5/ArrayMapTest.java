package ch5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ArrayMapTest {
    private static class MapHelper {
        public static <K, V> V get(ArrayMap<K, V> am, K key) {
            if (am.containsKey(key)) {
                return am.get(key);
            } else {
                return null;
            }
        }

        /**
         *  Returns the maximum of all keys in the given ArrayMap. Works only if keys can be compared.
         */
        public static <K extends Comparable<K>, V> K maxKey(Map61B<K, V> map61B) {
            List<K> aList = new ArrayList<>(map61B.keySet());
            if (aList.isEmpty()) {
                return null;
            }
            K mk =  aList.get(0);
            for (K key: aList) {
                if (key.compareTo(mk) > 0) {
                    mk = key;
                }
            }
            return mk;
        }
    }
    private Map61B<Integer, Integer> am;
    private MapHelper helper;
    @Before
    public void setUp() {
        ArrayMap<Integer, Integer> am = new ArrayMap<Integer, Integer>();
        this.am = am;
        this.helper = new MapHelper();
    }
    @Test
    public void test() {
        ArrayMap<Integer, Integer> am = new ArrayMap<Integer, Integer>();
        am.put(2, 5);
        int expected = 5;
        assertEquals((Integer)expected, am.get(2));
    }

    @Test
    public void getStaticNull() {
        assertNull(am.get(0));
    }

    @Test
    public void getStaticNonNull() {
        am.put(0, 100);
        assertEquals((Integer)100, am.get(0));
    }

    @Test
    public void maxKey() {
        am.put(0, 100);

        am.put(1, 101);
        am.put(2, 102);
        am.put(3, 103);
        Integer maxKey = this.helper.maxKey(this.am);
        assertTrue(maxKey.compareTo(3) == 0);
    }
}