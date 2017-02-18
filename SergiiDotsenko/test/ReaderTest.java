import library.Reader;
import org.junit.Assert;
import org.junit.*;

public class ReaderTest {
    private Reader reader;

    @Before
    public void setUp() {
        reader = new Reader();
    }

    @Test
    public void testTakeBook() {
        boolean cond = reader.takeBook();
        Assert.assertTrue(cond);
    }

    @Test
    public void testGetReaderID() {
        Reader rd = new Reader();
        int actual = rd.getReaderID();
        Assert.assertEquals(4, actual);
    }

    @Test
    public void testCanTakeBook(){
        boolean canTake = reader.canTakeBook();
        Assert.assertTrue(canTake);
    }
}
