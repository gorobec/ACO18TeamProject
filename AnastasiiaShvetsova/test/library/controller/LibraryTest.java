package library.controller;

import library.model.*;
import org.junit.*;

import java.util.*;

import static library.model.enums.BookGenre.MYSTERY;
import static library.model.enums.MagazineGenre.FASHION;
import static library.model.enums.NewspaperGenre.COMMERCIAL;
import static org.junit.Assert.*;

/**
 * Created by Nastia on 02.02.17.
 */
public class LibraryTest {

    private Library library;
    //readers

    Reader reader1 = new Reader("Vasia", "Ivanov", 25);
    Reader reader2 = new Reader("Jack", "Craig", 25);
    Reader reader3 = new Reader("Tom", "Toko", 25);
    Reader reader4 = new Reader("Ann", "Waso", 25);
    Reader reader5 = new Reader("Sara", "Belli", 25);
    Reader reader6 = new Reader("Bill", "Craig", 25);
    Reader reader7 = new Reader("Bob", "Toko", 25);
    Reader reader8 = new Reader("Kate", "Waso", 25);

    //authors
    Author author1 = new Author("Markus", "Zusak");
    Author pauloCoelho = new Author("Paulo", "Coelho");
    Author mohamad = new Author("Mohamad ", "Zahur");
    Author dan = new Author("Dan ", "Brown");
    Author anna = new Author("Anna ", "Vintur");

    //print editions
    PrintEdition book1 = new Book(author1, 2006, "The Book Thief");
    PrintEdition book2 = new Book(pauloCoelho, 2006, "The Alchemist");
    PrintEdition book3 = new Book(dan, 2006, "The Da Vinci Code");
    PrintEdition newspaper = new Newspaper(mohamad, 1995, "Kyiv Post", COMMERCIAL);
    PrintEdition magazine = new Magazine(anna, 1892, "Vogue", FASHION);
    PrintEdition book4 = new Book(dan, 2000, "Angels & Demons", MYSTERY);


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
        String str = "[{name='Ann', surname='Waso', age=25}, {name='Bill', surname='Craig', age=25}, {name='Bob', surname='Toko', age=25}, {name='Jack', surname='Craig', age=25}, {name='Kate', surname='Waso', age=25}, {name='Sara', surname='Belli', age=25}, {name='Tom', surname='Toko', age=25}, {name='Vasia', surname='Ivanov', age=25}]";
        library.addReader(reader1);
        library.addReader(reader2);
        library.addReader(reader3);
        library.addReader(reader4);
        library.addReader(reader5);
        library.addReader(reader6);
        library.addReader(reader7);
        library.addReader(reader8);
        assertEquals(str, library.showReaders());
    }

    @Test
    public void testShowRPrintEditions() {
        String str = "[{Mohamad Zahur, 1995, Kyiv Post}, {MarkusZusak, 2006, The Book Thief}, {Anna Vintur, 1892, Vogue}]";
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
        String str = "[{PauloCoelho, 2006, The Alchemist}, {MarkusZusak, 2006, The Book Thief}, {MarkusZusak, 2006, The Book Thief}]";

        assertEquals(str, library.showReadersPrinEdtitions());
    }

    @Test
    public void testShowCurrentReaderPrinEdtitions() {
        library.addReader(reader1);
        library.addReader(reader2);
        library.addPrintEdition(book2);
        library.addPrintEdition(book1);
        library.addPrintEdition(magazine);
        library.givePrintEditionForReader(book1, reader1);
        library.givePrintEditionForReader(book2, reader1);
        library.givePrintEditionForReader(book1, reader2);
        String str1 = "[{PauloCoelho, 2006, The Alchemist}, {MarkusZusak, 2006, The Book Thief}]";
        String str2 = "[{MarkusZusak, 2006, The Book Thief}]";

        assertEquals(str1, library.showCurrentReaderPrinEdtitions(reader1));
        assertEquals(str2, library.showCurrentReaderPrinEdtitions(reader2));

    }

    @Test
    public void testCheckReader() {
        library.addReader(reader1);
        library.addReaderToBlackList(reader2);
        assertTrue(library.checkReader(reader2));
        assertFalse(library.checkReader(reader3));

    }

    @Test
    public void testAddReaderToBlackList() {
        library.addReader(reader1);
        library.addReaderToBlackList(reader2);
        assertTrue(library.addReaderToBlackList(reader3));
        assertFalse(library.addReaderToBlackList(reader2));

    }

    @Test
    public void testShowPrintEditionCurrentAuthor() {
        library.addPrintEdition(book2);
        library.addPrintEdition(book3);
        library.addPrintEdition(book4);
        library.addPrintEdition(magazine);
        String str = "[{Dan Brown, 2000, Angels & Demons}, {Dan Brown, 2006, The Da Vinci Code}]";

        assertEquals(str, library.showPrintEditionCurrentAuthor(dan));
    }

    @Test
    public void testShowPrintEditionCurrentYear() {
        library.addPrintEdition(book2);
        library.addPrintEdition(book1);
        library.addPrintEdition(book3);
        library.addPrintEdition(magazine);
        String str = "[{PauloCoelho, 2006, The Alchemist}, {MarkusZusak, 2006, The Book Thief}, {Dan Brown, 2006, The Da Vinci Code}]";

        assertEquals(str, library.showPrintEditionCurrentYear(2006));
    }

    @Test
    public void testFindPrintEdition() {
        library.addPrintEdition(book2);
        library.addPrintEdition(book1);
        library.addPrintEdition(book3);
        library.addPrintEdition(magazine);

        assertTrue(library.findPrintEdition("vin"));
        assertFalse(library.findPrintEdition("van"));
    }

}
