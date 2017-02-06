package library.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by serhiim on 03-Feb-17.
 */
public class ReaderTest {
    private Reader reader;
    private Book book;

    @Before
    public void setUp() {
        reader = new Reader();
        book = new Book();
    }

    @Test
    public void testTakeBook() {
        assertEquals(0, reader.getCurrentItemsInHands());
        assertEquals(0, reader.getTakenItems().size());
        assertTrue(reader.takeItem(book));
        assertEquals(1, reader.getCurrentItemsInHands());
        assertEquals(1, reader.getTakenItems().size());
        assertTrue(reader.getTakenItems().contains(book));
    }

    @Test
    public void testReturnBook(){
        assertTrue(reader.takeItem(book));
        assertTrue(reader.returnItem(book));
        assertEquals(0, reader.getCurrentItemsInHands());
        assertEquals(0, reader.getTakenItems().size());
        assertFalse(reader.getTakenItems().contains(book));
    }
}
