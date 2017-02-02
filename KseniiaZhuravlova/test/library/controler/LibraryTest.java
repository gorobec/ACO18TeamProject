package library.controler;

import library.model.*;
import org.junit.*;

import static library.model.Genre.*;
import static org.junit.Assert.*;

/**
 * Created by ksyashka on 31.01.2017.
 */
public class LibraryTest {
    private Library library;

    @Before
    public void setUp() {
        library = new Library();
    }

    @Test
    public void testAddReaders() {
        assertTrue(library.addReader("Harrison", "Ford", 1975, 2, 11));
        assertTrue(library.addReader("Nicolas", "Cage", 1988, 1, 15));
        assertTrue(library.addReader("Alison", "Ford", 1977, 3, 28));
        assertTrue(library.addReader("Luc", "Besson", 1991, 9, 14));
        assertTrue(library.addReader("Alice", "Cooper", 1964, 3, 4));
        assertEquals(library.readers.size(), 5);
    }

    @Test
    public void testAddEditions() {
        Edition book1 = new Book("Crime and Punishment", "Dostoyevsky", 1995, 2, NOVEL);
        Edition book2 = new Book("The Idiot", "Dostoyevsky", 2002, 3, NOVEL);
        Edition book3 = new Book("The Master and Margarita", "Bulgakov", 1995, 2, NOVEL);
        Edition book4 = new Book("Inhabited Island", "Strugatsky", 1993, 1, FANTASTIC);
        Edition magazine1 = new Magazine("World of animals", "Adams", 2016, 12, 5);
        Edition magazine2 = new Magazine("World of animals", "Adams", 2016, 11, 4);
        Edition magazine3 = new Magazine("Popular Mechanics", "Johns", 2016, 12, 3);
        library.addEdition(book1);
        library.addEdition(magazine1);
        library.addEdition(book2);
        library.addEdition(magazine2);
        library.addEdition(book3);
        library.addEdition(magazine3);
        library.addEdition(book4);
        assertEquals(library.editions.size(), 7);
    }

    @Test
    public void testAddDuplicateEditions() {
        Edition book1 = new Book("Crime and Punishment", "Dostoyevsky", 1995, 2, NOVEL);
        Edition book2 = new Book("Crime and Punishment", "Dostoyevsky", 1995, 3, NOVEL);
        library.addEdition(book1);
        library.addEdition(book2);
        assertEquals(library.editions.size(), 1);
        Edition book = (Book) library.editions.get(0);
        assertEquals(book.getNumber(), 5);
    }

    @Test
    public void testAddReaderToBlacklist() {
        assertTrue(library.addReader("Harrison", "Ford", 1975, 2, 11));
        assertTrue(library.addReaderToBlackList(1));
        Reader reader = (Reader) library.readers.get(0);
        assertTrue(reader.isInBlackList());
    }

    @Test
    public void testGiveEditionToReader() {
        assertTrue(library.addReader("Harrison", "Ford", 1975, 2, 11));
        assertEquals(library.readers.size(), 1);
        Edition book1 = new Book("Crime and Punishment", "Dostoyevsky", 1995, 2, NOVEL);
        Edition book2 = new Book("The Idiot", "Dostoyevsky", 2002, 3, NOVEL);
        library.addEdition(book1);
        library.addEdition(book2);
        assertEquals(library.editions.size(), 2);
        library.giveEditionToReader(book1, 1);
        Reader tempReader = (Reader) library.readers.get(0);
        assertTrue(tempReader.getNumberOfEditions() == 1);
        library.giveEditionToReader(book1, 1);
        assertTrue(tempReader.getNumberOfEditions() == 2);
        library.giveEditionToReader(book1, 1);
        assertTrue(tempReader.getNumberOfEditions() == 2);
        library.giveEditionToReader(book2, 1);
        assertTrue(tempReader.getNumberOfEditions() == 3);
    }

    @Test
    public void testSortEditions() {
        Edition book1 = new Book("Crime and Punishment", "Dostoyevsky", 1995, 2, NOVEL);
        Edition book2 = new Book("The Idiot", "Dostoyevsky", 2002, 3, NOVEL);
        Edition book3 = new Book("The Master and Margarita", "Bulgakov", 1995, 2, NOVEL);
        Edition magazine1 = new Magazine("World of animals", "Adams", 2016, 12, 5);
        Edition magazine2 = new Magazine("Popular Mechanics", "Johns", 2016, 12, 3);
        library.addEdition(book1);
        assertEquals(book1, library.editions.get(0));
        library.addEdition(magazine1);
        assertEquals(magazine1, library.editions.get(1));
        library.addEdition(book2);
        assertEquals(book2, library.editions.get(2));
        library.addEdition(magazine2);
        assertEquals(magazine2, library.editions.get(3));
        library.addEdition(book3);
        assertEquals(book3, library.editions.get(4));
        library.sortEditions();
        assertEquals(book3, library.editions.get(0));
        assertEquals(book1, library.editions.get(1));
        assertEquals(book2, library.editions.get(2));
        assertEquals(magazine1, library.editions.get(3));
        assertEquals(magazine2, library.editions.get(4));
    }

    @Test
    public void testSortReaders() {
        assertTrue(library.addReader("Harrison", "Ford", 1975, 2, 11));
        assertTrue(library.addReader("Nicolas", "Cage", 1988, 1, 15));
        assertTrue(library.addReader("Alison", "Ford", 1977, 3, 28));
        Reader reader1 = new Reader(1, "Harrison", "Ford", 1975, 2, 11);
        Reader reader2 = new Reader(2, "Nicolas", "Cage", 1988, 1, 15);
        Reader reader3 = new Reader(3, "Alison", "Ford", 1977, 3, 28);
        assertEquals(reader1, library.readers.get(0));
        assertEquals(reader2, library.readers.get(1));
        assertEquals(reader3, library.readers.get(2));

        library.sortReaders();

        assertEquals(reader2, library.readers.get(0));
        assertEquals(reader3, library.readers.get(1));
        assertEquals(reader1, library.readers.get(2));
    }

}
