package library.controller;

import library.model.Book;
import library.model.PrintedEditions;
import library.model.Reader;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by User on 01.02.2017.
 */
public class TestLibrary {

    private Library library;
    private Reader reader;
    private PrintedEditions edition;

    @Before
    public void setUp () {
        library = new Library();
        reader = new Reader("Will", "Smith",40,"Kiev, Kreschatyk 17");
        edition = new Book("Effective java, 2nd ed", "Joshua Bloch",
                2008, 35, 384);
    }

    @After
    public void tearDown () {
        library=null;
        reader = null;
        edition  = null;
    }

    @Test
    public void testAddOneReader () {
       boolean actual = library.addReader(reader);
        Assert.assertTrue(actual);
    }


}
