package library.controller;

import library.model.*;
import library.model.comparators.ComparatorReaderByName;

import java.util.Comparator;

import static library.model.enums.MagazineGenre.*;
import static library.model.enums.BookGenre.*;
import static library.model.enums.NewspaperGenre.*;

/**
 * Created by Nastia on 31.01.17.
 */
public class Run {
    public static void main(String[] args) {
        Reader reader1 = new Reader("Vasia", "Ivanov", 25);
        Reader reader2 = new Reader("Jack", "Craig", 25);
        Reader reader3 = new Reader("Tom", "Toko", 25);
        Reader reader4 = new Reader("Ann", "Waso", 25);
        Reader reader5 = new Reader("Sara", "Belli", 25);
        Reader reader6 = new Reader("Bill", "Craig", 25);
        Reader reader7 = new Reader("Bob", "Toko", 25);
        Reader reader8 = new Reader("Kate", "Waso", 25);

        Author author1 = new Author("Markus", "Zusak");
        Author pauloCoelho = new Author("Paulo", "Coelho");
        Author mohamad = new Author("Mohamad ", "Zahur");
        Author dan = new Author("Dan ", "Brown");
        Author anna = new Author("Anna ", "Vintur");

        PrintEdition book1 = new Book(author1, 2006, "The Book Thief");
        PrintEdition book2 = new Book(pauloCoelho, 2006, "The Alchemist");
        PrintEdition book3 = new Book(dan, 2006, "The Da Vinci Code");
        PrintEdition newspaper = new Newspaper(mohamad, 1995, "Kyiv Post", Commercial );
        PrintEdition magazine = new Magazine(anna, 1892, "Vogue", Fashion);
        PrintEdition book4 = new Book(dan, 2000, "Angels & Demons", Mystery);


        Library newLibray = new Library();

        newLibray.addReader(reader1);
        newLibray.addReader(reader2);
        newLibray.addReader(reader3);
        newLibray.addReader(reader4);
        newLibray.addReader(reader5);
        newLibray.addReader(reader6);
        newLibray.addReader(reader7);
        newLibray.addReader(reader8);

        newLibray.addPrintEdition(book2);
        newLibray.addPrintEdition(book3);
        newLibray.addPrintEdition(newspaper);
        newLibray.addPrintEdition(magazine);
        newLibray.addPrintEdition(book1);
        newLibray.addPrintEdition(book4);


        System.out.println(newLibray.showPrinEdtitions());
//        System.out.println(newLibray.showReaders());

//        newLibray.givePrintEditionForReader(book1, reader1);
//        newLibray.givePrintEditionForReader(book2, reader1);
//        newLibray.givePrintEditionForReader(book1, reader2);

//        System.out.println(newLibray.showCurrentReaderPrinEdtitions(reader1));
//        System.out.println("showCurrentReaderPrinEdtitions " +newLibray.showCurrentReaderPrinEdtitions(reader2));
//        System.out.println("showReadersPrinEdtitions " +newLibray.showReadersPrinEdtitions());
        newLibray.addReaderToBlackList(reader3);
        System.out.println("Black list " + newLibray.getBlackLists().toString());
//        newLibray.givePrintEditionForReader(book1, reader3);
//        System.out.println(newLibray.showCurrentReaderPrinEdtitions(reader3));
//
//        newLibray.showPrintEditionCurrentAuthor(author1);
//
        System.out.println("CurrentAuthor " + newLibray.showPrintEditionCurrentAuthor(dan));
        System.out.println("CurrentYear " + newLibray.showPrintEditionCurrentYear(2006));
//       System.out.println(newLibray.findPrintEdition("vin"));
//        System.out.println(newLibray.findPrintEdition("van"));

    }
}
