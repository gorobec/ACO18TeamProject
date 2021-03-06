package ACO.week2.homework.library.utils;

import ACO.week2.homework.library.model.Library;
import ACO.week2.homework.library.model.Reader;
import ACO.week2.homework.library.model.printed_editions.Genre;
import ACO.week2.homework.library.model.printed_editions.PrintedEdition;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

    public static String showPrintedEditions(List<PrintedEdition> al, Comparator comparator) {

        if (al.size() == 0) {
            return "No printed editions.";
        }

        Collections.sort(al, comparator);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < al.size(); i++) {
            if (al.get(i) != null) {
                sb.append(i + 1).append(": ").append(al.get(i).toString()).append("\n");
            }
        }
        return sb.toString();
    }

    public static String showPrintedEditions(List<PrintedEdition> al) {

        if (al.size() == 0) {
            return "No printed editions.";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < al.size(); i++) {
            sb.append(i + 1).append(": ").append(al.get(i).toString()).append("\n");
        }
        return sb.toString();
    }
}
