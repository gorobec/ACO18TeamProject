package week5.day1.io;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by ksyashka on 18.02.2017.
 */
public class MyBashTest {
    private IBash iBash;
    @Before
    public void setUp(){
        iBash = new MyBash(".");
    }
    @Test
    public void pwd() throws Exception {

    }

    @Test
    public void cd() throws Exception {

    }

    @Test
    public void ls() throws Exception {

    }

    @Test
    public void cat() throws Exception {

    }

    @Test
    public void writeInto() throws Exception {

    }

    @Test
    public void append() throws Exception {

    }

    @Test
    public void touch() throws Exception {
        assertTrue(iBash.touch("files/test.txt"));
        File f = new File ("files/test.txt");
        assertTrue(f.exists());
    }

    @Test
    public void mkdir() throws Exception {

    }

    @Test
    public void find() throws Exception {

    }

}