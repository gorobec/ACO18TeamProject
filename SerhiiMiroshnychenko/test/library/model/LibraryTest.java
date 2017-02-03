package library.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by serhiim on 03-Feb-17.
 */
public class LibraryTest {
    private Reader reader1;
    private Reader reader2;
    private PrintedEdition printedEdition1;
    private PrintedEdition printedEdition2;
    private ArrayList<Reader> readers;
    private ArrayList<PrintedEdition> printedEditions;
    private Library lib;

    @Before
    public void setUp(){
        reader1 = new Reader();
        printedEdition1 = new PrintedEdition();
        printedEdition1.setCopiesCount(2);
        printedEdition2 = new PrintedEdition();
        printedEdition2.setCopiesCount(2);
        readers = new ArrayList<>();
        printedEditions = new ArrayList<>();
        readers.add(reader1);
        printedEditions.add(printedEdition1);
        lib = new Library(printedEditions, readers);
    }

    @Test
    public void testGiveBook(){
        assertTrue(lib.giveItem(reader1, printedEdition1));
        assertEquals(1, printedEdition1.getCopiesCount());
        assertEquals(1, reader1.getCurrentItemsInHands());
        assertTrue(reader1.getTakenItems().contains(printedEdition1));

    }

    @Test
    public void testTakeBook(){
        assertTrue(lib.giveItem(reader1, printedEdition1));
        assertTrue(lib.takeItem(reader1, printedEdition1));
        assertEquals(2, printedEdition1.getCopiesCount());
        assertEquals(0, reader1.getCurrentItemsInHands());
        assertFalse(reader1.getTakenItems().contains(printedEdition1));
    }

    @Test
    public void testGiveItemWhenReaderOrItemIsNotInArray(){
        assertFalse(lib.giveItem(reader2, printedEdition1));
        assertFalse(lib.giveItem(reader1, printedEdition2));

    }
}
