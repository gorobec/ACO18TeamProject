package library.model;

import library.controller.Library;
import org.junit.*;

import static org.junit.Assert.*;

public class TestPrintedEditions {

    private Library library;
    private Reader reader;
    private PrintedEditions edition;
    private PrintedEditions edition2;

    @Before
    public void setUp() {
        library = new Library();
        reader = new Reader("Will", "Smith", 40, "Kiev, Kreschatyk 17");
        edition = new Book("Effective java, 2nd ed", "Joshua Bloch",
                2008, 35, 384);
        edition2 = new Book("Effective java, 2nd ed", "Joshua Bloch",
                2008, 35, 384);
    }

    @After
    public void tearDown() {
        library = null;
        reader = null;
        edition = null;
        edition2 = null;
    }

    @Test
    public void testGetNumberOfCopiesAvailableWithoutLoan() {
        library.addPrintedEdition(edition);
        assertEquals(35, edition.getNumberOfCopiesAvailable());
    }

    @Test
    public void testGetNumberOfCopiesAvailableWithLoan() {
        library.addPrintedEdition(edition);
        library.addReader(reader);
        library.loanPrintedEdition(reader, edition);
        assertEquals(34, edition.getNumberOfCopiesAvailable());
    }

    @Test
    public void testGetNumberOfCopiesAtReadersWithoutLoan() {
        library.addPrintedEdition(edition);
        library.addReader(reader);
        assertEquals(0, edition.getNumberOfCopiesAtReader());
    }

    @Test
    public void testGetNumberOfCopiesAtReadersWithLoan() {
        library.addPrintedEdition(edition);
        library.addReader(reader);
        library.loanPrintedEdition(reader, edition);
        assertEquals(1, edition.getNumberOfCopiesAtReader());
    }

    @Test
    public void testShowEditionIsEmpty() {
        assertFalse(edition.showEdition().compareTo("") == 0);
    }

    @Test
    public void testShowEditionIsNotEmpty() {
        String s = "Name -    Effective java, 2nd ed, Author -              Joshua Bloch, year of  publication -   2008";
        assertTrue(edition.showEdition().compareTo(s) == 0);
    }

    @Test
    public void testEquals() {
        assertTrue(edition.equals(edition2));
    }

    @Test
    public void testNullEquals() {
        assertFalse(edition.equals(null));
    }

    @Test
    public void testSelfEquals() {
        assertTrue(edition.equals(edition));
    }
}
