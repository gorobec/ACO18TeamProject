package data_structures;
import org.junit.*;
import static org.junit.Assert.*;
/**
 * Created by Nastia on 29.01.17.
 */
public class MyArrayListTest {
    private MyArrayList list;

    @Before
    public void setUp(){
        list = new MyArrayList();
    }

    @Test
    public void testAddOneElement(){
        boolean actual = list.add("1");
        boolean expected = true;
        assertTrue(actual);
        assertEquals(1, list.size());
    }

    @Test
    public void testAddThreeElements(){
        assertTrue(list.add("0"));
        assertEquals(1, list.size());
        assertTrue(list.add("1"));
        assertEquals(2, list.size());
        assertTrue(list.add("2"));
        assertEquals(3, list.size());
        assertTrue(list.add("3"));
        assertEquals(4, list.size());
    }

    @Test
    public void testRemoveByObject(){
        list.add("12");
        list.add("13");
        int old = list.size();
        list.remove(1);
        assertEquals(old - 1, list.size());
    }

}
