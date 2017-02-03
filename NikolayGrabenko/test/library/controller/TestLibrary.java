package library.controller;

import library.comparators.PrintedEditionComparatorByName;
import library.model.Book;
import library.model.PrintedEditions;
import library.model.Reader;
import library.utils.ArrayListMy;
import org.junit.*;

import static org.junit.Assert.*;

public class TestLibrary {

    private Library library;
    private Reader reader;
    private PrintedEditions edition;

    @Before
    public void setUp() {
        library = new Library();
        reader = new Reader("Will", "Smith", 40, "Kiev, Kreschatyk 17");
        edition = new Book("Effective java, 2nd ed", "Joshua Bloch",
                2008, 35, 384);

    }

    @After
    public void tearDown() {
        library = null;
        reader = null;
        edition = null;
    }

    @Test
    public void testAddOneReader() {
        assertTrue(library.addReader(reader));
    }

    @Test
    public void testAddSameReader() {
        assertTrue(library.addReader(reader));
        assertFalse(library.addReader(reader));
    }

    @Test
    public void testAddNullInReaderField() {
        assertFalse(library.addReader(null));
    }

    @Test
    public void testIsRegistered() {
        assertFalse(library.isRegistered(reader));
    }

    @Test
    public void testIsRegisteredAfterAdding() {
        library.addReader(reader);
        assertTrue(library.isRegistered(reader));
    }

    @Test
    public void testIsRegisteredNull() {
        assertFalse(library.isRegistered(null));
    }

    @Test
    public void testIsRegisteredAfterKilling() {
        library.addReader(reader);
        reader = null;
        assertFalse(library.isRegistered(reader));
    }

    @Test
    public void testAddToBlackList() {
        assertTrue(library.addToBlackList(reader));
    }

    @Test
    public void testAddPrintedEdition() {
        assertTrue(library.addPrintedEdition(edition));
    }

    @Test
    public void testAddSamePrintedEdition() {
        assertTrue(library.addPrintedEdition(edition));
        assertTrue(library.addPrintedEdition(edition));
    }

    @Test
    public void testAddNullInPrintedEditionField() {
        assertFalse(library.addPrintedEdition(null));
    }

    @Test
    public void testAddNullInPrintedEditionField2() {
        edition = null;
        assertFalse(library.addPrintedEdition(edition));
    }

    @Test
    public void testIsAvailablePrintedEdition() {
        assertFalse(library.isAvailablePrintEds(edition));
    }

    @Test
    public void testIsAvailablePrintedEditionWhenReadersTookEverything() {
        library.addPrintedEdition(edition);
        edition.setNumberOfCopiesAvailable(0);
        assertFalse(library.isAvailablePrintEds(edition));
    }

    @Test
    public void testIsAvailablePrintedEditionAfterAdding() {
        library.addPrintedEdition(edition);
        assertTrue(library.isAvailablePrintEds(edition));
    }

    @Test
    public void testIsAvailablePrintedEditionIfNull() {
        library.addPrintedEdition(edition);
        edition = null;
        assertFalse(library.isAvailablePrintEds(edition));
    }


    @Test
    public void testLoanPrintedEditionWhenReaderNOTAdded() {
        assertTrue(!library.loanPrintedEdition(reader, edition)); // reader Not added
    }


    @Test
    public void testLoanPrintedEditionWhenReaderAddedWithoutEditionInLibrary() {
        library.addReader(reader);
        assertFalse(library.loanPrintedEdition(reader, edition)); // reader added,edition in NOT available
    }

    @Test
    public void testLoanPrintedEditionWhenReaderAddedWithEditionAdded() {
        library.addReader(reader);
        library.addPrintedEdition(edition);
        assertTrue(library.loanPrintedEdition(reader, edition)); // reader added,edition in library available
    }

    @Test
    public void testLoanPrintedEditionWhenReaderInBlackList() {
        library.addReader(reader);
        library.addPrintedEdition(edition);
        library.addToBlackList(reader);
        assertFalse(library.loanPrintedEdition(reader, edition));
    }

    @Test
    public void testShowPrintedEditionsAtOneReader() {
        library.loanPrintedEdition(reader, edition);
        String s = library.showPrintedEditionsAtOneReader(reader);
        assertFalse(s.compareTo("just some text") == 0);
    }

    @Test
    public void testShowPrintedEditionsAtOneReaderWithoutBooks() {
        String s = library.showPrintedEditionsAtOneReader(reader);
        assertTrue(s.compareTo("") == 0);
    }


    @Test
    public void testShowPrintedEditionsOfYearNoBookInLibrary (){
        assertFalse(library.showPrintedEditionsOfYear(2008, new PrintedEditionComparatorByName()));
    }

    @Test
    public void testShowPrintedEditionsOfYearOneBookInLibrary (){
        library.addPrintedEdition(edition);
        assertTrue(library.showPrintedEditionsOfYear(2008, new PrintedEditionComparatorByName()));
    }

    @Test
    public void testShowPrintedEditionsOfYearThreeBookInLibrary (){
        library.addPrintedEdition(edition);
        library.addPrintedEdition(edition);
        library.addPrintedEdition(edition);
        assertTrue(library.showPrintedEditionsOfYear(2008, new PrintedEditionComparatorByName()));
    }


}
