import library.common.MyArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by SDotsenko on 29.01.2017.
 */
public class MyArrayListTest {
    private MyArrayList list;

    @Before
    public void setUp() {
        list = new MyArrayList();
    }

    @Test
    public void testAddOneElement() {
        boolean actual = list.add("1");
        boolean expected = true;
//        Assert.assertEquals(expected,actual);
        Assert.assertTrue(actual);
    }

    @Test
    public void testSize(){
        list.add("6");
        list.add("5");
        list.add("3");
        int actual = list.size();
        int expected = 3;
        Assert.assertEquals(actual,expected);
    }
}
