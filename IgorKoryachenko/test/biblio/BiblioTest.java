package biblio;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Игорь on 02.02.2017.
 */
public class BiblioTest {
    private Library library;

    @Before
    public void setLibrary() {
         library = new Library();
    }

    @Test
    public void testShowReaders(){
    library.readers.add("111");
    library.readers.add("111");
    library.readers.add("111");

    StringBuilder actual = new StringBuilder( "111\n111\n111\n");
        Assert.assertEquals(library.showReaders(), actual);
    }
}
