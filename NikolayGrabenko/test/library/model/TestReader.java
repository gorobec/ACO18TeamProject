package library.model;

import library.controller.Library;
import org.junit.*;

import static org.junit.Assert.*;

public class TestReader {

    private Library library;
    private Reader reader;
    private Reader reader2;
    private PrintedEditions edition;

    @Before
    public void setUp() {
        library = new Library();
        reader = new Reader("Will", "Smith", 40, "Kiev, Kreschatyk 17");
        reader2 = new Reader("Will", "Smith", 40, "Kiev, Kreschatyk 17");
        edition = new Book("Effective java, 2nd ed", "Joshua Bloch",
                2008, 35, 384);
    }

    @After
    public void tearDown() {
        library = null;
        reader = null;
        reader2 = null;
        edition = null;
    }

    @Test
    public void testGetName() {
        assertTrue(reader.getName().compareTo("Will") == 0);
    }

    @Test(expected = NullPointerException.class)
    public void testGetNameNull() {
        reader = null;
        assertFalse(reader.getName().compareTo("Will") == 0);
    }

    @Test
    public void testGetCounterOfPrinEdsNotAdded() {
        assertEquals(0, reader.getCounterOfPrintEds());
    }

    @Test
    public void testGetCounterOfPrinEds1Added() {
        library.addPrintedEdition(edition);
        library.addReader(reader);
        library.loanPrintedEdition(reader, edition);
        assertEquals(1, reader.getCounterOfPrintEds());
    }

    @Test
    public void testGetCounterOfPrinEds2Added() {
        library.addPrintedEdition(edition);
        library.addReader(reader);
        library.loanPrintedEdition(reader, edition);
        library.loanPrintedEdition(reader, edition); // we can't loan same book
        assertEquals(1, reader.getCounterOfPrintEds());
    }

    @Test
    public void testIsNotInBlackListAfterRegistation() {
        library.addReader(reader);
        assertTrue(reader.isNotInBlackList());
    }

    @Test
    public void testIsNotInBlackListAfterAddToBL() {
        library.addReader(reader);
        library.addToBlackList(reader);
        assertFalse(reader.isNotInBlackList());
    }

    @Test
    public void testAddPrintedEditionToList() {
        assertTrue(reader.addPrintedEditionToList(edition));
    }

    @Test
    public void testIsEditionInReaderList() {
        library.addReader(reader);
        library.addPrintedEdition(edition);
        library.loanPrintedEdition(reader, edition);
        assertTrue(reader.isEditionInReaderList(edition));
    }

    @Test
    public void testEquals() {
        assertTrue(reader.equals(reader2));
    }

    @Test
    public void testNullEquals() {
        assertFalse(reader.equals(null));
    }

    @Test
    public void testSelfEquals() {
        assertTrue(reader.equals(reader));
    }
}
