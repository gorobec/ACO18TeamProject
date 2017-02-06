package ACO.week2.homework.library.controller;

import ACO.week2.homework.library.controller.interfaces.ILibraryPEController;
import ACO.week2.homework.library.model.Library;
import ACO.week2.homework.library.model.Reader;
import ACO.week2.homework.library.model.printed_editions.Genre;
import ACO.week2.homework.library.model.printed_editions.PrintedEdition;
import ACO.week2.homework.library.utils.Utils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        List<PrintedEdition> authorList = library.getPrintedEditionsInLibrary()
                .stream()
                .filter(s -> s.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());

        return Utils.showPrintedEditions(authorList, comparator);
    }

    public String showCertainYearPrintedEditions(int year, Comparator comparator) {
        List<PrintedEdition> yearList = library.getPrintedEditionsInLibrary()
                .stream()
                .filter(s -> s.getYear() == year)
                .collect(Collectors.toList());

        return Utils.showPrintedEditions(yearList, comparator);
    }

    public String showPrintedEditionAllReaders(Comparator comparator) {

        List<PrintedEdition> readersEditions = library.getReaders()
                .stream()
                .flatMap(reader -> reader.getPrintedEditions().stream())
                .collect(Collectors.toList());

        return Utils.showPrintedEditions(readersEditions, comparator);
    }

    public String showPrintedEditionCertainReader(Reader reader, Comparator comparator) {
        return Utils.showPrintedEditions(reader.getPrintedEditions(), comparator);
    }

    public boolean givePrintedEditionToReader(Reader reader, PrintedEdition printedEdition) {

        // check if reader exists in our library
        // then compare links (if they are exactly the same)
        // so we use "==" instead of equals()
        if (library.getReaders().contains(reader)

                && reader == library.getReaders()
                .get(library.getReaders().indexOf(reader))

                && library.getPrintedEditionsInLibrary().contains(printedEdition)

                && printedEdition == library.getPrintedEditionsInLibrary()
                .get(library.getPrintedEditionsInLibrary().indexOf(printedEdition))) {

            if (reader.isInBlackList()) {
                System.out.println("Reader in blacklist");
                return false;
            }

            return library.getPrintedEditionsInLibrary().contains(printedEdition)
                    && reader.addPrintedEdition(printedEdition)
                    && library.removePrintedEdition(printedEdition);
        }
        return false;
    }

    public String findPrintedEditionByKeywords(String keywords, Comparator comparator) {
        String[] keywordsArray = keywords.toLowerCase().split(", ");
        List<PrintedEdition> foundEditions = Arrays.stream(keywordsArray)
                .flatMap(keyword -> library.getPrintedEditionsInLibrary()
                        .stream().filter(
                                pe -> pe.getAuthor().toLowerCase().contains(keyword)
                                        || pe.getName().toLowerCase().contains(keyword)
                                        || pe.getGenre().toString().toLowerCase().contains(keyword)))
                .collect(Collectors.toList());

        return foundEditions.size() == 0 ? "Not found" : "Found :\n" + Utils.showPrintedEditions(foundEditions, comparator);
    }
}
