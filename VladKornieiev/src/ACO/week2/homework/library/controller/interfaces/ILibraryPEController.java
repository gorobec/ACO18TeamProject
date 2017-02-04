package ACO.week2.homework.library.controller.interfaces;

import ACO.week2.homework.library.model.Reader;
import ACO.week2.homework.library.model.printed_editions.PrintedEdition;

import java.util.Comparator;

/**
 * Created by v21k on 31.01.17.
 */
public interface ILibraryPEController {
    PrintedEdition createNewPrintedEdition(String name, int genre, String author, String year);

    String showAllPrintedEditionsInLibrary(Comparator comparator);

    boolean addPrintedEdition(PrintedEdition printedEdition);

    String showCertainAuthorPrintedEditions(String string, Comparator comparator);

    String showCertainYearPrintedEditions(int year, Comparator comparator);

    String showPrintedEditionAllReaders(Comparator comparator);

    String showPrintedEditionCertainReader(Reader reader, Comparator comparator);

    String findPrintedEditionByKeywords(String keywords, Comparator comparator);

    boolean givePrintedEditionToReader(Reader reader, PrintedEdition printedEdition);
}
