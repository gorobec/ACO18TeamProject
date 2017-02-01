package ACO.week2.homework.library.controller;

import ACO.data_structures.MyArrayList;
import ACO.week2.homework.library.controller.interfaces.ILibraryPEController;
import ACO.week2.homework.library.model.Library;
import ACO.week2.homework.library.model.Reader;
import ACO.week2.homework.library.model.printed_editions.Genre;
import ACO.week2.homework.library.model.printed_editions.PrintedEdition;
import ACO.week2.homework.library.utils.Utils;

import java.util.Comparator;

/**
 * Created by v21k on 31.01.17.
 */
public class LibraryPEController implements ILibraryPEController {
    private Library library;

    public LibraryPEController(Library library) {
        this.library = library;
    }

    public PrintedEdition createNewPrintedEdition(String name, int genre, String author, String year) {

        // validation
        if (name.matches("^\\D+,*.*$")
                && (genre > 0 && genre <= Genre.values().length)
                && author.matches("^\\D+,*.*$")
                && (year.matches("^\\d+$") && Integer.parseInt(year) <= 2017)) {

            PrintedEdition printedEdition = new PrintedEdition(Genre.values()[genre - 1], name, author, Integer.parseInt(year));
            return printedEdition;
        }
        return null;
    }

    public boolean addPrintedEdition(PrintedEdition printedEdition) {
        return library.addPrintedEdition(printedEdition);
    }

    public String showAllPrintedEditionsInLibrary(Comparator comparator) {
        return Utils.showPrintedEditions(library.getPrintedEditionsInLibrary(), comparator);
    }

    public String showCertainAuthorPrintedEditions(String author, Comparator comparator) {

        MyArrayList authorList = new MyArrayList();

        // adding only PE of certain author
        for (int i = 0; i < library.getPrintedEditionsInLibrary().size(); i++) {
            PrintedEdition printedEdition = (PrintedEdition) library.getPrintedEditionsInLibrary().get(i);
            if (printedEdition.getAuthor().equalsIgnoreCase(author)) {
                authorList.add(printedEdition);
            }
        }
        return Utils.showPrintedEditions(authorList, comparator);
    }

    public String showCertainYearPrintedEditions(int year, Comparator comparator) {
        MyArrayList yearList = new MyArrayList();

        // adding only PE of certain year
        for (int i = 0; i < library.getPrintedEditionsInLibrary().size(); i++) {
            PrintedEdition printedEdition = (PrintedEdition) library.getPrintedEditionsInLibrary().get(i);
            if (printedEdition.getYear() == (year)) {
                yearList.add(printedEdition);
            }
        }

        return Utils.showPrintedEditions(yearList, comparator);
    }

    public String showPrintedEditionAllReaders(Comparator comparator) {
        MyArrayList readersEditions = new MyArrayList();

        // looking for PEs and add all to readersEditions AL
        for (int i = 0; i < library.getReaders().size(); i++) {
            Reader reader = (Reader) library.getReaders().get(i);
            for (int j = 0; j < reader.getPrintedEditions().size(); j++) {
                readersEditions.add(reader.getPrintedEditions().get(j));
            }
        }
        return Utils.showPrintedEditions(readersEditions, comparator);
    }

    public String showPrintedEditionCertainReader(Reader reader, Comparator comparator) {
        return Utils.showPrintedEditions(reader.getPrintedEditions(), comparator);
    }

    public boolean givePrintedEditionToReader(Reader reader, PrintedEdition printedEdition) {
        if (library.getBlackList().contains(reader)) {
            System.out.println("Reader in blacklist");
            return false;
        }

        return library.getPrintedEditionsInLibrary().contains(printedEdition)
                && reader.addPrintedEdition(printedEdition)
                && library.removePrintedEdition(printedEdition);
    }

    public String findPrintedEditionByKeywords(String keywords, Comparator comparator) {

        String[] keywordsArray = keywords.toLowerCase().split(", ");

        PrintedEdition[] printedEditions = Utils.printedEditionsToArray(library.getPrintedEditionsInLibrary());
        MyArrayList foundEditions = new MyArrayList();

        findMatches(keywordsArray, printedEditions, foundEditions);

        if (foundEditions.size() == 0) {
            return "Not found";
        }
        return "Found :\n" + Utils.showPrintedEditions(foundEditions, comparator);

    }

    private void findMatches(String[] keywordsArray, PrintedEdition[] printedEditions, MyArrayList foundEditions) {
        for (PrintedEdition pe : printedEditions) {
            for (String keyword : keywordsArray) {
                if (pe.getAuthor().toLowerCase().contains(keyword)
                        || pe.getName().toLowerCase().contains(keyword)
                        || pe.getGenre().toString().toLowerCase().contains(keyword)) {
                    foundEditions.add(pe);
                    break;
                }
            }
        }
    }
}
