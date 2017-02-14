package library.comparators;

import library.model.Reader;
import org.junit.*;
import static org.junit.Assert.*;

public class TestReaderSurnameComparator {

    private Reader reader1;
    private Reader reader2;
    private ReaderSurNameComparator comp;
    @Before
    public void setUp() {
        reader1 = new Reader("Will", "Smith", 40, "Kiev, Kreschatyk 17");
        reader2 = new Reader("Jared", "Smith", 18, "Kiev, Kreschatyk 17");
        comp = new ReaderSurNameComparator();
    }

    @After
    public void tearDown() {
        reader1 = null;
        reader2 = null;
        comp = null;
    }

    @Test
    public void testCompareSurName () {
        assertTrue((comp.compare (reader1,reader2))==0);
    }

    @Test(expected = NullPointerException.class)
    public void testCompareSurNameNull () {
        assertFalse((comp.compare (reader1,null))==0);
    }
}
