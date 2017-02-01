package week1.day1;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * Created by ksyashka on 01.02.2017.
 */
public class CatTest {
    private Cat cat;

    @Before
    public void setUp(){cat = new Cat ("Vaska",8);}


    @Test
    public void testToString(){
        String expected = String.format("Cat name - %s, age - %d", cat.getName(),cat.getAge());
        assertTrue(expected.equals(cat.toString()));
    }

    @Test
    public void testAddCatToList() {
        //Cat ("Vaska",8) вызывается два раза в листе будет уже два кота
        assertEquals(cat.cats.size() , 2);
    }

}
