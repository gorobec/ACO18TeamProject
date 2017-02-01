package library.controller;

import library.model.*;
import org.junit.*;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by Nastia on 02.02.17.
 */
public class LibraryTest {

    private Library library;

    Reader reader1 = new Reader("Vasia", "Ivanov", 25);
    Reader reader2 = new Reader("Jack", "Craig", 25);
    Reader reader3 = new Reader("Tom", "Toko", 25);
    Reader reader4 = new Reader("Ann", "Waso", 25);
    Author author1 = new Author("Markus", "Zusak");
    Author pauloCoelho = new Author("Paulo", "Coelho");
    Author mohamad = new Author("Mohamad ", "Zahur");
    Author dan = new Author("Dan ", "Brown");
    Author anna = new Author("Anna ", "Vintur");

    PrintEdition book1 = new Book(author1, 2006, "The Book Thief");
    PrintEdition book2 = new Book(pauloCoelho, 2006, "The Alchemist");
    PrintEdition book3 = new Book(dan, 2006, "The Da Vinci Code");
    PrintEdition newspaper = new Newspaper(mohamad, 1995, "Kyiv Post");
    PrintEdition magazine = new Magazine(anna, 1892, "Vogue");

    @Before
    public void setUp() {
        library = new Library();
    }

    @Test
    public void testAddReader() {
        assertTrue(library.addReader(reader1));
        assertTrue(library.addReader(reader2));
    }

    @Test
    public void testPrintEdition() {
        assertTrue(library.addPrintEdition(book1));
        assertTrue(library.addPrintEdition(book2));
    }

    @Test
    public void testShowReaders() {
        String str = "[{name='Ann', surname='Waso', age=25}, {name='Jack', surname='Craig', age=25}]";
        library.addReader(reader4);
        library.addReader(reader2);
        assertEquals(str, library.showReaders());
    }

    @Test
    public void testShowRPrintEditions() {
        String str = "[{Mohamad Zahur, 1995, Kyiv Post}, {MarkusZusak, 2006, The Book Thief}, {Anna Vintur, 1892, Vogue}, null]";
        library.addPrintEdition(newspaper);
        library.addPrintEdition(book1);
        library.addPrintEdition(magazine);
        assertEquals(str, library.showPrinEdtitions());
    }

    @Test
    public void testIsPrintEditionAvailable() {
        library.addPrintEdition(book1);
        library.addPrintEdition(book1);
        assertTrue(library.addPrintEdition(book2));
        assertTrue(library.addPrintEdition(book3));

    }

    @Test
    public void testGivePrintEditionForReader() {
        library.addReader(reader1);
        library.addReader(reader2);
        library.addPrintEdition(book1);
        library.addPrintEdition(book2);
        library.addReaderToBlackList(reader3);
        assertTrue(library.givePrintEditionForReader(book1, reader1));
        assertFalse(library.givePrintEditionForReader(book3, reader1));
        assertFalse(library.givePrintEditionForReader(book1, reader3));

    }
    @Test
    public void testShowReadersPrintEditions() {
        library.addReader(reader1);
        library.addReader(reader2);
        library.addPrintEdition(book2);
        library.addPrintEdition(book1);
        library.addPrintEdition(magazine);
        library.givePrintEditionForReader(book1, reader1);
        library.givePrintEditionForReader(book2, reader1);
        library.givePrintEditionForReader(book1, reader2);
        String str = "[{MarkusZusak, 2006, The Book Thief}, {PauloCoelho, 2006, The Alchemist}, {MarkusZusak, 2006, The Book Thief}, null]";

        assertEquals(str, library.showReadersPrinEdtitions());
    }
}
