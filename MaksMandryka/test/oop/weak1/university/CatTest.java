package oop.weak1.university;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by fmandryka on 31.01.2017.
 */
public class CatTest {

    private Cat c1 = new Cat("Murzik", 3);
    private Cat c2 = new Cat("Barsik", 2);
    private Cat c3 = new Cat("Murchik", 5);
    private Cat c4 = new Cat("Murlo", 1);
    private Cat c5 = new Cat("Hunter", 7);
    private Cat c6 = new Cat("Einshtein", 10);
    private Cat c7 = new Cat("Sherlok", 6);
    private Cat c8 = new Cat("Cesar", 5);
    private Cat c9 = new Cat("Parasit", 2);
    private Cat c10 = new Cat("Figaro", 3);

    @Test
    public void testPrintCats(){
        String expected = "Name = Murzik age = 3 \n" +
                "Name = Barsik age = 2 \n" +
                "Name = Murchik age = 5 \n" +
                "Name = Murlo age = 1 \n" +
                "Name = Hunter age = 7 \n" +
                "Name = Einshtein age = 10 \n" +
                "Name = Sherlok age = 6 \n" +
                "Name = Cesar age = 5 \n" +
                "Name = Parasit age = 2 \n" +
                "Name = Figaro age = 3 \n";
        System.out.println(c10.printCats());
        assertEquals(expected, c10.printCats());
    }

}
