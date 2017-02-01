package ACO.week2.homework.library.utils;

import ACO.data_structures.MyArrayList;
import ACO.week2.homework.library.controller.interfaces.ILibraryReaderController;
import ACO.week2.homework.library.model.Library;
import ACO.week2.homework.library.model.Reader;
import ACO.week2.homework.library.model.printed_editions.Book;
import ACO.week2.homework.library.model.printed_editions.Genre;
import ACO.week2.homework.library.model.printed_editions.Journal;
import ACO.week2.homework.library.model.printed_editions.PrintedEdition;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by v21k on 31.01.17.
 */
public class Utils {

    private static Scanner sc = new Scanner(System.in);

    // to make our library alive
    public static boolean initLibrary(Library library) {
        Journal journal = new Journal(Genre.JOURNAL, "Vogue", "Some Author", 2015);
        Book book = new Book(Genre.FANTASY, "Harry Potter", "Joanne Rowling", 2008);
        PrintedEdition printedEdition = new PrintedEdition(Genre.SCIENCE, "Science", "MTI", 2013);

        library.addPrintedEdition(journal);
        library.addPrintedEdition(book);
        library.addPrintedEdition(printedEdition);

        Reader reader1 = new Reader("Andrii");
        Reader reader2 = new Reader("Sasha");
        Reader reader3 = new Reader("Vlad");

        library.addReader(reader1);
        library.addReader(reader2);
        library.addReader(reader3);

        return true;
    }

    public static String showPrintedEditions(MyArrayList al, Comparator comparator) {

        if (al.size() == 0) {
            return "No printed editions.";
        }

        PrintedEdition[] printedEditions = printedEditionsToArray(al);
        Arrays.sort(printedEditions, comparator);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < printedEditions.length; i++) {
            sb.append(i + 1).append(": ").append(printedEditions[i].toString()).append("\n");
        }
        return sb.toString();
    }

    public static String showPrintedEditions(MyArrayList al) {

        if (al.size() == 0) {
            return "No printed editions.";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < al.size(); i++) {
            sb.append(i + 1).append(": ").append(al.get(i).toString()).append("\n");
        }
        return sb.toString();
    }

    public static int getComparatorChoice() {
        System.out.println("Choose sort comparator: ");
        System.out.println("1. By name");
        System.out.println("2. By author");
        System.out.println("3. By year");
        return sc.nextInt();
    }

    public static int getReaderChoice(ILibraryReaderController lr) {
        System.out.println("Choose reader (number)");
        System.out.println(lr.showAllReaders());
        return sc.nextInt();
    }

    public static Reader[] readersToArray(MyArrayList myArrayList) {
        Reader[] readers = new Reader[myArrayList.size()];
        for (int i = 0; i < myArrayList.size(); i++) {
            readers[i] = (Reader) myArrayList.get(i);
        }
        return readers;
    }

    public static PrintedEdition[] printedEditionsToArray(MyArrayList myArrayList) {
        PrintedEdition[] printedEditions = new PrintedEdition[myArrayList.size()];
        for (int i = 0; i < myArrayList.size(); i++) {
            printedEditions[i] = (PrintedEdition) myArrayList.get(i);
        }
        return printedEditions;
    }
}
