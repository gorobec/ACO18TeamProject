package IBash.tests;

import IBash.io.MyBash;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by zhenia on 18.02.17.
 */
public class MyBashTest1 {
    private MyBash bash;

    @Before
    public void setUp() {
        bash = new MyBash();
    }

    @Test
    public void testCat() throws Exception {
        System.out.println(bash.cat("hello.txt"));
        Assert.assertNull(bash.cat(null));
    }

    @Test
    public void testLs(){
        List<File> list = new ArrayList<>();

        for (File file : new File(System.getProperty("user.dir")).listFiles()) {
            list.add(file);
        }

        Assert.assertEquals(list, bash.ls());
    }

    @Test
    public void testMkdir(){
        Assert.assertFalse(bash.mkdir("hello"));
        bash.ls();
    }

    @Test
    public void testWriteInto() throws Exception{
        Assert.assertFalse(bash.writeInto("", ""));
        Assert.assertFalse(bash.writeInto("hello", ""));
        Assert.assertTrue(bash.writeInto("hello.txt", "hello1"));
        System.out.println(bash.cat("hello.txt"));
    }

    @Test
    public void testTouch() throws Exception{
        Assert.assertFalse(bash.touch(""));
        Assert.assertTrue(bash.touch("hello1.txt"));
        System.out.println(bash.cat("hello1.txt"));
    }

    @Test
    public void testAppend() throws Exception{
        Assert.assertFalse(bash.writeInto("", ""));
        Assert.assertFalse(bash.writeInto("hello", ""));
        bash.writeInto("hello.txt", "hello1");
        Assert.assertTrue(bash.append("hello.txt", "\nhello2"));
        System.out.println(bash.cat("hello.txt"));
    }

    @Test
    public void testFind() throws Exception{
        Assert.assertEquals(bash.find("hello.txt", "/home/zhenia/IdeaProjects").get(0).getName(), "hello.txt");
        Assert.assertNull(bash.find("helloooo.txt", "/home/zhenia/IdeaProjects/week5"));
        Assert.assertNull(bash.find("", "/home"));
    }

    @Test(expected = InvalidPathException.class)
    public void testFind2() throws Exception{
        bash.find("hello.txt", "/home/zhenia/IdeaProjects/wfgeghejgiuwhu");
    }

}