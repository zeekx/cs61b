package ch9;

import org.junit.Before;

import static org.junit.Assert.*;

public class WeightedQuickUnionDSTest extends DisjointSetsTest {

    @Before
    public void setUp() throws Exception {
        super.setUp();
        DisjointSetsTest.N = 10;
        this.ds = new WeightedQuickUnionDS(DisjointSetsTest.N);
    }
}