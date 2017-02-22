package oop.week5.io;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by fmandryka on 18.02.2017.
 */
public class IBashTest {

    private IBash iBash;

    @Before
    public void setUp() throws Exception {
        iBash = new MyBash("src\\oop\\week5\\io");
    }


    @Test (expected = FileNotFoundException.class)
    public void readWhenFileNotFoundTest() throws Exception {
        String contents = iBash.cat("test\\oop\\week5\\io\\CatTest.txtw");
    }

    @Test (expected = NoSuchDirectoryException.class)
    public void missDirectoryInConstructorTest() throws Exception {
        IBash iBash2 = new MyBash("src\\oop\\week5\\ioe");
    }

    @Test
    public void pwdTest() throws Exception {
        System.out.println("\nTest .pwd()");
        System.out.println(iBash.pwd());
    }

    @Test
    public void cdTest() throws Exception {
        IBash iBash2 = new MyBash("src\\");
        String newPath = iBash.cd("src");
        Assert.assertEquals(iBash2.pwd(), newPath);
    }

    @Test
    public void lsTest() throws Exception {
        List<File> list = new ArrayList<>();
        list.add(new File("src\\oop\\week5\\io\\IBash.java").getAbsoluteFile());
        list.add(new File("src\\oop\\week5\\io\\MyBash.java").getAbsoluteFile());
        list.add(new File("src\\oop\\week5\\io\\NoSuchDirectoryException.java").getAbsoluteFile());
        Assert.assertEquals(list, iBash.ls());
    }

    @Test
    public void catTest() throws Exception {
        Assert.assertEquals("Test successful", iBash.cat("test\\oop\\week5\\io\\CatTest.txt"));
    }

    @Test
    public void writeInfoTest() throws Exception {
        iBash.writeInfo("test\\oop\\week5\\io\\WriteTest.txt", "Test");
        Assert.assertEquals("Test", iBash.cat("test\\oop\\week5\\io\\WriteTest.txt"));
    }

    @Test
    public void append() throws Exception {
        String oldContent = iBash.cat("test\\oop\\week5\\io\\AppendTest.txt");
        iBash.append("test\\oop\\week5\\io\\AppendTest.txt", "Test2");
        Assert.assertEquals(oldContent + "Test2", iBash.cat("test\\oop\\week5\\io\\AppendTest.txt"));
    }

    @Test
    public void touchTest() throws Exception {
        iBash.touch("test\\oop\\week5\\io\\TouchTest.txt");
        File file = new File("test\\oop\\week5\\io\\TouchTest.txt");
        Assert.assertTrue(file.exists());
        file.delete();
    }

    @Test
    public void touchWhenExistsTest() throws Exception {
        Assert.assertFalse(iBash.touch("test\\oop\\week5\\io\\AppendTest.txt"));
    }

    @Test
    public void mkdirTest() throws Exception {
        iBash.mkdir("test\\oop\\week5\\io\\MkdirTest");
        File directory = new File("test\\oop\\week5\\io\\MkdirTest");
        Assert.assertTrue(directory.exists());
        directory.delete();
    }

    @Test
    public void mkdirWhenExistsTest() throws Exception {
        Assert.assertFalse(iBash.mkdir("test\\oop\\week5\\io"));
    }

    @Test
    public void findTest() throws Exception {
        List<File> list = new ArrayList<>();
        list.add(new File("src\\oop\\week5\\io").getAbsoluteFile());
        list.add(new File("src\\oop\\week5\\io\\IBash.java").getAbsoluteFile());
        list.add(new File("src\\oop\\week5\\io\\MyBash.java").getAbsoluteFile());
        list.add(new File("src\\oop\\week5\\io\\NoSuchDirectoryException.java").getAbsoluteFile());
        List<File> foundFiles1 = iBash.find("io", "src\\oop\\week5");
        Assert.assertEquals(list, foundFiles1);

        List<File> list2 = new ArrayList<>();
        list2.add(new File("src\\oop\\week5\\io\\IBash.java").getAbsoluteFile());
        List<File> foundFiles2 = iBash.find("IBASH.java", "src\\oop\\week5\\io");
        Assert.assertEquals(list2, foundFiles2);
    }


}