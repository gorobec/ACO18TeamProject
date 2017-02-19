package oop.week5.io;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by fmandryka on 18.02.2017.
 */
public class IBashTest {

    private IBash iBash;

    @Before
    public void setUp() throws Exception {
        iBash = new MyBash("C:\\Users\\f.mandryka\\Documents\\Idea\\ACO18TeamProject\\MaksMandryka");

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void pwd() throws Exception {

    }

    @Test
    public void cd() throws Exception {
        String newPath = iBash.cd("src");
        Assert.assertEquals("C:\\Users\\f.mandryka\\Documents\\Idea\\ACO18TeamProject\\MaksMandryka\\src", newPath);
    }

    @Test
    public void ls() throws Exception {

    }

    @Test
    public void cat() throws Exception {

    }

    @Test
    public void writeInfo() throws Exception {

    }

    @Test
    public void append() throws Exception {

    }

    @Test
    public void touch() throws Exception {

    }

    @Test
    public void mkdir() throws Exception {

    }

    @Test
    public void find() throws Exception {

    }

}