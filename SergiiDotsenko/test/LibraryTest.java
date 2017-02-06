import library.Book;
import library.Library;
import library.Readers;
import org.junit.Assert;
import org.junit.Test;

import static library.PublicationType.*;

/**
 * Created by SDotsenko on 02.02.2017.
 */
public class LibraryTest {
    private Library library;

//    @Before
//    public void setUp() {
//        Readers readers = new Readers();
//        Library library = new Library(readers);
//    }

    @Test
    public void testAddBook() {
        Readers readers = new Readers();
        Library library = new Library(readers);
        library.addBook(new Book(DIRECTORY, "a1", 1999));
        int expected = 2;
        int actual = library.addBook(new Book(ENCYCLOPEDIA, "ff", 2222));
        Assert.assertEquals(actual, expected);
    }
}
