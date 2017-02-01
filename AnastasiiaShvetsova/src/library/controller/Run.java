package library.controller;

import library.model.*;
import library.model.comparators.ComparatorPrintEditionByName;
import library.model.comparators.ComparatorReaderByName;

import java.util.Comparator;

/**
 * Created by Nastia on 31.01.17.
 */
public class Run {
    public static void main(String[] args) {
        Reader reader1 = new Reader("Vasia", "Ivanov", 25);
        Reader reader2 = new Reader("Jack", "Craig", 25);
        Reader reader3 = new Reader("Tom", "Toko", 25);
        Reader reader4 = new Reader("Ann", "Waso", 25);
        Author author1 = new Author("Markus","Zusak" );
        Author pauloCoelho = new Author("Paulo", "Coelho");
        Author mohamad = new Author("Mohamad ", "Zahur");
        Author dan = new Author("Dan ", "Brown");
        Author anna = new Author("Anna ", "Vintur");

        PrintEdition book1 = new Book(author1,2006, "The Book Thief");
        PrintEdition book2 = new Book(pauloCoelho,2006, "The Alchemist");
        PrintEdition book3 = new Book(dan,2006, "The Da Vinci Code");
        PrintEdition newspaper = new Newspaper(mohamad, 1995,"Kyiv Post");
        PrintEdition magazine = new Magazine(anna, 1892, "Vogue");

        Comparator comparatorByName  = new ComparatorReaderByName();

        Library newLibray = new Library();
        newLibray.addReader(reader1);
        newLibray.addReader(reader2);
        newLibray.addReader(reader3);
        newLibray.addReader(reader4);
        newLibray.addPrintEdition(book1);
        newLibray.addPrintEdition(book2);
        newLibray.addPrintEdition(book3);
        newLibray.addPrintEdition(newspaper);
        newLibray.addPrintEdition(magazine);
        newLibray.sortReaders(comparatorByName);
        System.out.println(newLibray.showPrinEdtitions());
        System.out.println(newLibray.showReaders());

        newLibray.givePrintEditionForReader(book1, reader1);
        newLibray.givePrintEditionForReader(book2, reader1);
        newLibray.givePrintEditionForReader(book1, reader2);
        System.out.println(newLibray.showCurrentReaderPrinEdtitions(reader1));
        System.out.println(newLibray.showCurrentReaderPrinEdtitions(reader2));
        System.out.println(newLibray.showReadersPrinEdtitions());
        newLibray.addReaderToBlackList(reader3);
        System.out.println("Black list " + newLibray.blackLists.toString());
        newLibray.givePrintEditionForReader(book1, reader3);
        System.out.println(newLibray.showCurrentReaderPrinEdtitions(reader3));

        newLibray.showPrintEditionCurrentAuthor(author1);

        System.out.println(newLibray.showPrintEditionCurrentAuthor(author1));
        System.out.println(newLibray.findPrintEdition("vin"));
        System.out.println(newLibray.findPrintEdition("van"));

    }
}
