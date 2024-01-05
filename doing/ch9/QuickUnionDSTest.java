package ch9;

import org.junit.Before;

import static org.junit.Assert.*;

public class QuickUnionDSTest extends DisjointSetsTest {

    @Before
    public void setUp() throws Exception {
        super.setUp();
        DisjointSetsTest.N = 100;
        this.ds = new QuickUnionDS(QuickUnionDSTest.N);
    }
}