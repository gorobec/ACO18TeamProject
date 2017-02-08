package library.utils;

import org.junit.*;

import static org.junit.Assert.*;

public class TestArrayListMy extends TestListMy {

    @Override
    @Before
    public void setUp() {
        list = new ArrayListMy();
    }

}
