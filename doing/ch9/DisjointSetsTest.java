package ch9;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class DisjointSetsTest {

    public DisjointSets ds;
    public static int N = 7;
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void isConnectedNone() {
        if (ds == null) {
            return;
        }
        assertFalse(ds.isConnected(0, N-1));
    }

    @Test
    public void isConnected0_6() {
        if (ds == null) {
            return;
        }

        ds.connect(0, N-1);
        assertTrue(ds.isConnected(0, N-1));
    }

    @Test
    public void isConnectedAll() {
        if (ds == null) {
            return;
        }

        for (int i = 0; i < DisjointSetsTest.N; i++) {
            for (int j = i + 1; j < DisjointSetsTest.N; j++) {
                ds.connect(i, j);
                assertTrue(ds.isConnected(i, j));
            }
        }
    }

    @Test
    public void connectedRandom() {
        if (ds == null) {
            return;
        }

        List<Integer> list = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        for (int i = 0; i < N-1; i++) {
            ds.connect(list.get(i), list.get(i+1));
        }

        for (int i = 0; i < N-1; i++) {
            assertTrue(ds.isConnected(i, i+1));
        }

    }

    @Test
    public void isConnected() {
        if (ds == null) {
            return;
        }

        for (int i = 0; i < DisjointSetsTest.N; i++) {
            for (int j = i + 1; j < DisjointSetsTest.N; j++) {
                assertFalse(ds.isConnected(i, j));
            }
        }
    }
}