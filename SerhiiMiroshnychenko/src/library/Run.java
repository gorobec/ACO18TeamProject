package library;

import library.model.Book;
import library.model.Library;
import library.model.PrintedEdition;
import library.model.Reader;

import java.util.ArrayList;

/**
 * Created by serhiim on 02-Feb-17.
 */
public class Run {
    public static void main(String[] args) {
        PrintedEdition book1 = new Book("qwe", "Qweasd", "Edition name1", "Address",
                "01-01-1980", "Fantastic", 200);
        PrintedEdition book2 = new Book("asd", "Asdfgh",  "Edition name1", "Address",
                "01-01-1980", "Fantastic", 200);
        PrintedEdition book3 = new Book("zxc", "Zxcvbn",  "Edition name1", "Address",
                "01-01-1980", "Fantastic", 200);
        PrintedEdition book4 = new Book("Cxz", "Nbvcxz",  "Edition name2", "Address1",
                "01-01-1980", "Fantastic", 200);

        Reader reader1 = new Reader();
        Reader reader2 = new Reader();
        Reader reader3 = new Reader();
        ArrayList<Reader> readers = new ArrayList<>();
        readers.add(reader1);
        readers.add(reader2);



        System.out.println(book1.equals(book2));
        System.out.println(book1.equals(book1));
        System.out.println(book1.toString());

        ArrayList<PrintedEdition> printedEditions = new ArrayList<>();
        printedEditions.add(book1);
        printedEditions.add(book2);
        printedEditions.add(book3);
        Library lib = new Library(printedEditions, readers);
        lib.giveBook(reader1, book1);
        lib.giveBook(reader1, book3);
        lib.giveBook(reader1, book4);
        System.out.println(reader1.getTakenBooks().toString());

        lib.giveBook(reader3, book1);

        System.out.println(reader3.getTakenBooks().toString());


    }
}
