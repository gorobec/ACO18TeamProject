package oop.week5.io;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by fmandryka on 18.02.2017.
 */
public class IBashTest {

    private IBash iBash;

    @Before
    public void setUp() throws Exception {
        iBash = new MyBash("\\Idea\\ACO18TeamProject\\MaksMandryka\\src\\oop\\week5\\io");

    }

    @Test
    public void pwd() throws Exception {
        Assert.assertEquals(iBash.pwd(),"");
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
    public void catTest() throws Exception {
        System.out.println(iBash.cat("MaksMandryka.iml"));
    }

    @Test
    public void writeInfo() throws Exception {
        iBash.writeInfo("D:\\Test.txt", "Test");
    }

    @Test
    public void append() throws Exception {
        iBash.append("D:\\Test.txt", "Test2");
    }

    @Test
    public void touch() throws Exception {
        iBash.touch("tttt.txt");
    }

    @Test
    public void mkdir() throws Exception {

    }

    @Test
    public void find() throws Exception {
        List<File> foundFiles = iBash.find("Andrey", "C:\\Users\\f.mandryka\\Documents\\Idea\\ACO18TeamProject");
        iBash.ls();
    }

}