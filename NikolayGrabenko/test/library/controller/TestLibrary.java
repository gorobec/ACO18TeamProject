package library.controller;

import library.comparators.*;
import library.model.Book;
import library.model.PrintedEditions;
import library.model.Reader;
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
        assertTrue(!library.loanPrintedEdition("Will", "Smith", 40, edition)); // reader Not added
    }


    @Test
    public void testLoanPrintedEditionWhenReaderAddedWithoutEditionInLibrary() {
        library.addReader(reader);
        assertFalse(library.loanPrintedEdition("Will", "Smith", 40, edition)); // reader added,edition in NOT available
    }

    @Test
    public void testLoanPrintedEditionWhenReaderAddedWithEditionAdded() {
        library.addReader(reader);
        library.addPrintedEdition(edition);
        assertTrue(library.loanPrintedEdition("Will", "Smith", 40, edition)); // reader added,edition in library available
    }

    @Test
    public void testLoanPrintedEditionWhen2ReaderAddedWith2EditionAdded() {
        library.addReader(reader);
        library.addPrintedEdition(edition);
        assertTrue(library.loanPrintedEdition("Will", "Smith", 40, edition));
        assertTrue(reader.getReaderEditions().size() == 1);
        assertTrue(edition.getNumberOfCopiesAvailable() == 34);
        Reader reader2 = new Reader("Will", "Smith", 40, "Kiev, Kreschatyk 17");
        PrintedEditions edition2 = new Book("Some test book", "Dontsova",
                2008, 1, 384);
        assertFalse(library.addReader(reader2));
        assertTrue(library.addPrintedEdition(edition2));
        assertTrue(library.loanPrintedEdition("Will", "Smith", 40, edition2));
        assertTrue(reader.getReaderEditions().size() == 2);
        assertTrue(edition2.getNumberOfCopiesAvailable() == 0);
        reader2 = null;
        edition2 = null;
    }

    @Test
    public void testLoanPrintedEditionWhenReaderInBlackList() {
        library.addReader(reader);
        library.addPrintedEdition(edition);
        library.addToBlackList(reader);
        assertFalse(library.loanPrintedEdition("Will", "Smith", 40, edition));
    }


    @Test
    public void testShowPrintedEditionsAtOneReader() {
        library.loanPrintedEdition("Will", "Smith", 40, edition);
        String s = library.showPrintedEditionsAtOneReader(reader);
        assertFalse(s.compareTo("just some text") == 0);
    }

    @Test
    public void testShowPrintedEditionsAtOneReaderWithoutBooks() {
        String s = library.showPrintedEditionsAtOneReader(reader);
        assertTrue(s.compareTo("") == 0);
    }

    @Test
    public void testShowPrintedEditionsAtOneReaderWithBooks() {
        library.addReader(reader);
        library.addPrintedEdition(edition);
        library.loanPrintedEdition("Will", "Smith", 40, edition);
        String s = library.showPrintedEditionsAtOneReader(reader);
        assertFalse(s.compareTo("") == 0);
    }


    @Test
    public void testShowPrintedEditionsOfYearNoBookInLibrary() {
        assertFalse(library.showPrintedEditionsOfYear(2008, new PrintedEditionComparatorByName()));
    }

    @Test
    public void testShowPrintedEditionsOfYearOneBookInLibrary() {
        library.addPrintedEdition(edition);
        assertTrue(library.showPrintedEditionsOfYear(2008, new PrintedEditionComparatorByName()));
    }

    @Test
    public void testShowPrintedEditionsOfYearThreeBookInLibrary() {
        library.addPrintedEdition(edition);
        library.addPrintedEdition(edition);
        library.addPrintedEdition(edition);
        assertTrue(library.showPrintedEditionsOfYear(2008, new PrintedEditionComparatorByName()));
    }

    @Test
    public void testShowPrintedEditionsOfAuthorNoBookInLibrary() {
        assertFalse(library.showPrintedEditionsOfAuthor("Joshua Bloch", new PrintedEditionComparatorByName()));
    }

    @Test
    public void testShowPrintedEditionsOfAuthorOneBookInLibrary() {
        library.addPrintedEdition(edition);
        assertTrue(library.showPrintedEditionsOfAuthor("Joshua Bloch", new PrintedEditionComparatorByName()));
    }

    @Test
    public void testShowPrintedEditionsOfAuthorThreeBookInLibrary() {
        library.addPrintedEdition(edition);
        library.addPrintedEdition(edition);
        library.addPrintedEdition(edition);
        assertTrue(library.showPrintedEditionsOfAuthor("Joshua Bloch", new PrintedEditionComparatorByName()));
    }

    @Test
    public void testFindStringByKeyWordStandart() {
        assertTrue(library.findStringByKeyWord("Some string", "Some"));
    }

    @Test
    public void testFindStringByKeyWordIgnoreCase() {
        assertTrue(library.findStringByKeyWord("Some string", "STRING"));
    }

    @Test
    public void testFindStringByKeyWordKeyNull() {
        assertFalse(library.findStringByKeyWord("Some string", null));
    }

    @Test
    public void testFindPrintedEditionByKeyWord() {
        library.addPrintedEdition(edition);
        assertEquals(library.findPrintedEditionByKeyWord("java", new PrintedEditionComparatorByName()), edition);
    }

    @Test
    public void testFindStringByKeyWordStringNull() {
        assertFalse(library.findStringByKeyWord(null, "Key word"));
    }

    @Test
    public void testFindStringByKeyWordStringShorterKey() {
        assertFalse(library.findStringByKeyWord("Some string", "Some stringggg"));
    }

    @Test
    public void testShowAllRegisteredReadersNotAdded() {
        assertFalse(library.showAllRegisteredReaders(new ReaderNameComparator()));
    }

    @Test
    public void testShowAllRegisteredReadersAdded() {
        library.addReader(reader);
        assertTrue(library.showAllRegisteredReaders(new ReaderNameComparator()));
    }

    @Test
    public void testShowAllRegisteredReadersAddedNull() {
        library.addReader(null);
        assertFalse(library.showAllRegisteredReaders(new ReaderNameComparator()));
    }

    @Test
    public void testShowPrintedEditionsNotAdded() {
        assertFalse(library.showPrintedEditions(new PrintedEditionComparatorByName()));
    }

    @Test
    public void testShowPrintedEditionsAdded() {
        library.addPrintedEdition(edition);
        assertTrue(library.showPrintedEditions(new PrintedEditionComparatorByName()));
    }

    @Test
    public void testShowPrintedEditionsAddedNull() {
        library.addPrintedEdition(null);
        assertFalse(library.showPrintedEditions(new PrintedEditionComparatorByName()));
    }

    @Test
    public void testShowPrintedEditionsAvailableNotAdded() {
        assertFalse(library.showPrintedEditions(new PrintedEditionComparatorByName()));
    }

    @Test
    public void testShowPrintedEditionsAvailableAdded() {
        library.addPrintedEdition(edition);
        assertTrue(library.showPrintedEditions(new PrintedEditionComparatorByName()));
    }

    @Test
    public void testShowPrintedEditionsAvailableAddedNull() {
        library.addPrintedEdition(null);
        assertFalse(library.showPrintedEditions(new PrintedEditionComparatorByName()));
    }

    @Test
    public void testShowPrintedEditionsAtReadersNotAddedEdition() {
        library.addReader(reader);
        assertFalse(library.showPrintedEditionsAtReaders(new PrintedEditionComparatorByName()));
    }

    @Test
    public void testShowPrintedEditionsAtReadersNotAddedReader() {
        library.addPrintedEdition(edition);
        assertFalse(library.showPrintedEditionsAtReaders(new PrintedEditionComparatorByName()));
    }

    @Test
    public void testShowPrintedEditionsAtReadersAdded() {
        library.addPrintedEdition(edition);
        library.addReader(reader);
        library.loanPrintedEdition("Will", "Smith", 40, edition);
        assertTrue(library.showPrintedEditionsAtReaders(new PrintedEditionComparatorByName()));
    }

    @Test
    public void testShowPrintedEditionsAtReadersAddedNullReader() {
        library.addReader(null);
        library.addPrintedEdition(edition);
        assertFalse(library.showPrintedEditionsAtReaders(new PrintedEditionComparatorByName()));
    }

    @Test
    public void testShowPrintedEditionsAtReadersAddedNullEdition() {
        library.addReader(reader);
        library.addPrintedEdition(null);
        assertFalse(library.showPrintedEditionsAtReaders(new PrintedEditionComparatorByName()));
    }
}
