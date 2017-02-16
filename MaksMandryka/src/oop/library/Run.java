package oop.library;

import oop.library.controller.Library;
import oop.library.model.Reader;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by fmandryka on 31.01.2017.
 */
public class Run {

    public static void main(String[] args) {

        Reader r1 = new Reader("Max", "Mandryka", new GregorianCalendar(2005,10,20));
        Reader r2 = new Reader("Stas", "Miroshnik", new GregorianCalendar(2003,1,20));
        Reader r3 = new Reader("Alex", "Porter", new GregorianCalendar(2001,4,20));
        Reader r4 = new Reader("Serhii", "Koval", new GregorianCalendar(2000,6,20));
        Reader r5 = new Reader("Max", "Mandryka", new GregorianCalendar(2006,10,20));
        Reader r6 = new Reader("Maks", "Mandryka", new GregorianCalendar(2006,10,20));

        Library lib = Library.getInstance();

        lib.addReader(r1);
        lib.addReader(r2);
        lib.addReader(r3);
        lib.addReader(r4);
        lib.addReader(r5);
        lib.addReader(r6);

        lib.getReaders();


        lib.getReaders();
    }
}
