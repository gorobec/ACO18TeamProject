package library.controler;
import org.junit.*;
import static org.junit.Assert.*;
/**
 * Created by ksyashka on 31.01.2017.
 */
public class LibraryTest {
    private Library library;

    @Before
    public void setUp() { library = new Library();}

    @Test
    public void testAddReader(){
        assertTrue(library.addReader("Harrison", "Ford", 1975, 2, 11));
        assertEquals(library.readers.size() , 1);
    }

    @Test
    public void testAddFiveReader(){
        assertTrue(library.addReader("Harrison", "Ford", 1975, 2, 11));
        assertEquals(library.readers.size() , 1);
        assertTrue(library.addReader("Nicolas", "Cage", 1988, 1, 15));
        assertEquals(library.readers.size() , 2);
        assertTrue(library.addReader("Alison", "Ford", 1977, 3, 28));
        assertEquals(library.readers.size() , 3);
        assertTrue(library.addReader("Luc", "Besson", 1991, 9, 14));
        assertEquals(library.readers.size() , 4);
        assertTrue(library.addReader("Alice", "Cooper", 1964, 3, 4));
        assertEquals(library.readers.size() , 5);
    }

    @Test
    public void testAddEdition(){

    }
}
