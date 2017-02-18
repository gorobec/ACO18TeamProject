package week4.sort;

import org.junit.Before;

/**
 * Created by ksyashka on 17.02.2017.
 */
public class TestMergeSort extends TestSort {
    @Before
    public void setUp() {
        sort = new MergeSort<>();
    }
}
