package library.comparators;

import library.model.Book;
import library.model.PrintedEditions;
import org.junit.*;
import static org.junit.Assert.*;

public class TestPrintedEditionComparatorByAuthor {

    private PrintedEditions editions1;
    private PrintedEditions editions2;
    private PrintedEditionComparatorByAuthor comp;

    @Before
    public void setUp() {
        editions1 = new Book("Effective java, 2nd ed", "Joshua Bloch",
                2008, 35, 384);
        editions2 = new Book("Thinking in Java", "Bruce Eckel",
                2006, 20, 1079);
        comp = new PrintedEditionComparatorByAuthor();
    }

    @After
    public void tearDown() {
        editions1 = null;
        editions2 = null;
        comp = null;
    }

    @Test
    public void testCompareAuthor () {
        assertFalse((comp.compare (editions1,editions2))==0);
    }

    @Test(expected = NullPointerException.class)
    public void testCompareAuthorNull () {
        assertFalse((comp.compare (editions1,null))==0);
    }

}
