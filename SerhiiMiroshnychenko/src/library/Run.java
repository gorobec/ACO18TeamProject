package library;

import library.model.*;

import java.util.ArrayList;

/**
 * Created by serhiim on 02-Feb-17.
 */
public class Run {
    public static void main(String[] args) {
        PrintedEdition book1 = new Book("qwe", "Qweasd", "Edition name1", "Address",
                "01-01-1980", Genre.FANTASY, 200);
        PrintedEdition book2 = new Book("asd", "Asdfgh", "Edition name1", "Address",
                "01-01-1980", Genre.ADVENTURE, 200);
        PrintedEdition book3 = new Book("zxc", "Zxcvbn", "Edition name1", "Address",
                "01-01-1980", Genre.BIOGRAPHIES, 200);
        PrintedEdition book4 = new Book("Cxz", "Nbvcxz", "Edition name2", "Address1",
                "01-01-1980", Genre.ENCYCLOPEDIAS, 200);

        Reader reader1 = new Reader("Vasia", "Petrov", 20);
        Reader reader2 = new Reader("Petia", "Vasiliev", 22);
        Reader reader3 = new Reader();
        ArrayList<Reader> readers = new ArrayList<>();
        readers.add(reader1);
        readers.add(reader2);

        ArrayList<PrintedEdition> printedEditions = new ArrayList<>();
        printedEditions.add(book1);
        printedEditions.add(book2);
        printedEditions.add(book3);
        Library lib = new Library(printedEditions, readers);
        lib.giveItem(reader1, book1);
        lib.giveItem(reader1, book3);
        lib.giveItem(reader1, book4);
        System.out.println(reader1.getTakenItems().toString());

        lib.giveItem(reader3, book1);

        System.out.println(reader3.getTakenItems().toString());

        lib.takeItem(reader1, book1);
        System.out.println(reader1.getTakenItems().toString());

        System.out.println(reader1.getLibraryCardNumber());
        System.out.println(reader2.getLibraryCardNumber());
        System.out.println(reader3.getLibraryCardNumber());
        lib.giveItem(reader2, book1);
        lib.giveItem(reader2, book2);
        System.out.println("***************************");
        System.out.println(reader1.getTakenItems());
        System.out.println(reader2.getTakenItems());

        System.out.println("***************************");

        System.out.println(lib.getAllTakenItems());

        System.out.println("***************************");

        System.out.println(lib.getTakenItemsByReader(reader2));

    }

}