package ACO.data_structures;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by v21k on 06.02.17.
 */
public class MyLinkedListTest extends MyListTest {
    @Override
    public void setUp() {
        list = new MyLinkedList<>();
    }

    @Test
    public void clearTest(){
        list.add("2");
        list.add("2");
        list.add("2");
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void indexOfNull(){
        list.add("!");
        list.add(null);
        assertEquals(1, list.indexOf(null));
    }
}
