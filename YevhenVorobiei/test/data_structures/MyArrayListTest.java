package data_structures;

import org.junit.*;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.After;
import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;
import static org.junit.Assert.*;

/**
 * Created by gorobec on 29.01.17.
 */
public class MyArrayListTest {
    private MyArrayList list;

    @Before
    public void setUp() {
        list = new MyArrayList();
    }

    @After
    public void tearDown() {
        list = null;
    }

    @Test
    @Ignore
    public void testAddOneElement() {
        boolean actual = list.add("1");

        assertTrue(actual);
        assertEquals(1, list.size());
    }

    @Test
    public void testAddThreeElements() {
        assertEquals(0, list.size());
        assertTrue(list.add("0"));
        assertEquals(1, list.size());
        assertTrue(list.add("1"));
        assertEquals(2, list.size());
        assertTrue(list.add("2"));
        assertEquals(3, list.size());
    }

    @Test
    public void testRemoveWhenElementPresent() {
        assertTrue(list.add("0"));
        assertTrue(list.add("1"));
        assertTrue(list.add("1"));
        assertTrue(list.remove("1"));
        assertEquals(2, list.size());
    }

    @Test
    public void testRemoveNullWhenElementPresent() {
        assertTrue(list.add("0"));
        assertTrue(list.add(null));
        assertTrue(list.add(null));
        assertTrue(list.remove(null));
        assertEquals(2, list.size());
    }

    @Test
    public void testRemoveWhenNoElementPresent() {
        assertTrue(list.add("0"));
        assertTrue(list.add("1"));
        assertTrue(list.add("1"));
        assertFalse(list.remove("2"));
        assertEquals(3, list.size());
    }

    @Test
    public void testRemoveNullWhenNoElementPresent() {
        assertTrue(list.add("0"));
        assertTrue(list.add("1"));
        assertTrue(list.add("1"));
        assertFalse(list.remove(null));
        assertEquals(3, list.size());
    }

    @Test
    public void testRemoveWhenEmptyList() {
        assertEquals(0, list.size());
        assertFalse(list.remove("2"));
        assertEquals(0, list.size());
    }

    @Test
    public void testRemoveNullWhenEmptyList() {
        assertEquals(0, list.size());
        assertFalse(list.remove(null));
        assertEquals(0, list.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveWrongIndex() {
            list.remove(-1);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetWhenEmptyList(){
        list.get(-5);
    }
}
