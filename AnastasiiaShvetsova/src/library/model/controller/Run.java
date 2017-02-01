package library.model.controller;

import library.model.Book;
import library.model.Newspaper;
import library.model.PrintEdition;
import library.model.Reader;

import java.util.Arrays;

/**
 * Created by Nastia on 31.01.17.
 */
public class Run {
    public static void main(String[] args) {
        Reader reader1 = new Reader("Vasia", "Ivanov", 25);
        Reader reader2 = new Reader("Vasia2", "Ivanov2", 25);

        PrintEdition book1 = new Book("book1");
        PrintEdition book2 = new Newspaper("nees");

        Library newLibray = new Library();
        newLibray.addReader(reader1);
        newLibray.addReader(reader2);
        newLibray.addPrintEdition(book1);
        newLibray.addPrintEdition(book2);
        System.out.println(newLibray.toString());
    }
}
