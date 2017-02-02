package ACO.week2.homework.library.controller;

import ACO.week2.homework.library.comparators.PEByNameComparator;
import ACO.week2.homework.library.controller.interfaces.ILibraryPEController;
import ACO.week2.homework.library.controller.interfaces.ILibraryReaderController;
import ACO.week2.homework.library.model.Library;
import ACO.week2.homework.library.model.Reader;
import ACO.week2.homework.library.model.printed_editions.Genre;
import ACO.week2.homework.library.model.printed_editions.PrintedEdition;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Created by v21k on 01.02.17.
 */
public class LibraryControllerTest {


    Library library = new Library();
    ILibraryPEController lp = new LibraryPEController(library);
    ILibraryReaderController lr = new LibraryReaderController(library);
    PrintedEdition pe = new PrintedEdition(Genre.JOURNAL, "Some Edition", "VK", 1995);
    Reader reader = new Reader("Vlad");

    @After
    public void tearDown() {
        library = null;
        lp = null;
        lr = null;
        pe = null;
        reader = null;
    }

    @Test
    public void addExistingPrintedEdition() {
        assertTrue(lp.addPrintedEdition(pe));
    }

    @Test
    public void addNonExistentPrintedEdition() {
        assertFalse(lp.addPrintedEdition(null));
    }

    @Test
    public void showPrintedEditionsEmptyLibrary() {
        assertEquals("No printed editions.", lp.showAllPrintedEditionsInLibrary(new PEByNameComparator()));
    }

    @Test
    public void showPrintedEditionsNonEmptyLibrary() {
        lp.addPrintedEdition(pe);
        assertEquals("1: Name : Some Edition, genre : JOURNAL, author : VK, year : 1995\n",
                lp.showAllPrintedEditionsInLibrary(new PEByNameComparator()));
    }

    @Test
    public void showPrintedEditionsAllReadersWhenNoEditions() {
        assertEquals("No printed editions.",
                lp.showPrintedEditionAllReaders(new PEByNameComparator()));
    }

    @Test
    public void showPrintedEditionsAllReadersWithEditions() {
        lp.addPrintedEdition(pe);
        lr.addReader(reader);
        lp.givePrintedEditionToReader(reader, pe);
        assertEquals("1: Name : Some Edition, genre : JOURNAL, author : VK, year : 1995\n",
                lp.showPrintedEditionAllReaders(new PEByNameComparator()));
    }

    @Test
    public void showPrintedEditionCertainReaderWhenNoSuchReader() {
        assertEquals("No printed editions.",
                lp.showPrintedEditionCertainReader(reader, new PEByNameComparator()));
    }

    @Test
    public void showPrintedEditionCertainReaderWhenReaderExists() {
        lr.addReader(reader);
        lp.addPrintedEdition(pe);
        lp.givePrintedEditionToReader(reader, pe);
        assertEquals("1: Name : Some Edition, genre : JOURNAL, author : VK, year : 1995\n",
                lp.showPrintedEditionCertainReader(reader, new PEByNameComparator()));
    }

    @Test
    public void givePEToReaderWhenNoPE() {
        lr.addReader(reader);
        assertFalse(lp.givePrintedEditionToReader(reader, pe));
    }

    @Test
    public void givePEToReaderWhenReaderInBlackList() {
        lp.addPrintedEdition(pe);
        lr.addReader(reader);
        lr.addReaderToBlackList(reader);
        assertFalse(lp.givePrintedEditionToReader(reader, pe));
    }

    @Test
    public void givePEToReaderWhenNoEdition() {
        lr.addReader(reader);
        assertFalse(lp.givePrintedEditionToReader(reader, pe));
    }

    @Test
    public void givePEToReaderWhenReaderMoreThan3() {
        reader.setCurrentPrintedEditionsNumber(3);
        lp.addPrintedEdition(pe);
        lr.addReader(reader);
        assertFalse(lp.givePrintedEditionToReader(reader, pe));
    }

    @Test
    public void createNewPEWrongInput() {
        assertEquals(null,
                lp.createNewPrintedEdition("2334", 2, "bla-bla", "1990"));
    }

    @Test
    public void createNewPENormalInput() {
        PrintedEdition pe = new PrintedEdition(Genre.ROMANCE, "Somebook", "bla-bla", 1990);
        assertEquals(pe,
                lp.createNewPrintedEdition("Somebook", 2, "bla-bla", "1990"));
    }

    @Test
    public void showCertainAuthorWrongInput() {
        lp.addPrintedEdition(pe);
        assertEquals("No printed editions.",
                lp.showCertainAuthorPrintedEditions("bla-bla", new PEByNameComparator()));
    }

    @Test
    public void showCertainAuthorNormalInput() {
        lp.addPrintedEdition(pe);
        assertEquals("1: Name : Some Edition, genre : JOURNAL, author : VK, year : 1995\n",
                lp.showCertainAuthorPrintedEditions("VK", new PEByNameComparator()));
    }

    @Test
    public void showCertainYearWrongInput() {
        lp.addPrintedEdition(pe);
        assertEquals("No printed editions.",
                lp.showCertainYearPrintedEditions(1000, new PEByNameComparator()));
    }

    @Test
    public void showCertainYearNormalInput() {
        lp.addPrintedEdition(pe);
        assertEquals("1: Name : Some Edition, genre : JOURNAL, author : VK, year : 1995\n",
                lp.showCertainYearPrintedEditions(1995, new PEByNameComparator()));
    }

    @Test
    public void showAllReaderWhenEmpty() {
        assertEquals("No readers", lr.showAllReaders());
    }

    @Test
    public void showAllReaderWhenReaderExists() {
        lr.addReader(reader);
        assertEquals("1: Name - Vlad, current number of printed editions - 0\n",
                lr.showAllReaders());
    }


}
