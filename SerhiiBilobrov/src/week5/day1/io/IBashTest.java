package week5.day1.io;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Serhii Bilobrov
 * @since 1.7
 */
public class IBashTest {

    private IBash iBash;

    @Before
    public void setUp() throws Exception {
        iBash = new MyBash("/home/data/serhii/dev/IdeaProjects/ACO18TeamProject/SerhiiBilobrov");
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testPwd() throws Exception {

    }

    @Test
    public void testCd() throws Exception {
        String newCurr = iBash.cd("src");
        Assert.assertEquals("/home/data/serhii/dev/IdeaProjects/ACO18TeamProject/SerhiiBilobrov/src", newCurr);

        String newCurr2 = iBash.cd("/home");

        Assert.assertEquals("/home", newCurr2);

        String newCurr3 = iBash.cd("/hosdfe");

        Assert.assertNull(newCurr3);
    }

    @Test
    public void testLs() throws Exception {

    }

    @Test
    public void testCat() throws Exception {

    }

    @Test
    public void testWriteInto() throws Exception {

    }

    @Test
    public void testAppend() throws Exception {

    }

    @Test
    public void testTouch() throws Exception {

    }

    @Test
    public void testMkdir() throws Exception {

    }

    @Test
    public void testFind() throws Exception {

    }
}