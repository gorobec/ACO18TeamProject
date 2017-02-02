package ACO.week2.homework.library.utils;

import ACO.data_structures.MyArrayList;
import ACO.week2.homework.library.model.*;
import ACO.week2.homework.library.model.printed_editions.*;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by v21k on 31.01.17.
 */
public class Utils {

    // to make our library alive
    public static boolean initLibrary(Library library) {
        PrintedEdition journal = new PrintedEdition(Genre.JOURNAL, "Vogue", "Some Author", 2015);
        PrintedEdition book = new PrintedEdition(Genre.FANTASY, "Harry Potter", "Joanne Rowling", 2008);
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
            if (printedEditions[i] != null) {
                sb.append(i + 1).append(": ").append(printedEditions[i].toString()).append("\n");
            }
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
