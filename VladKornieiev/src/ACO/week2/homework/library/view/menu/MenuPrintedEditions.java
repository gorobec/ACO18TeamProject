package ACO.week2.homework.library.view.menu;

import ACO.week2.homework.library.comparators.PEByAuthorComparator;
import ACO.week2.homework.library.comparators.PEByNameComparator;
import ACO.week2.homework.library.comparators.PEByYearComparator;
import ACO.week2.homework.library.controller.interfaces.ILibraryPEController;
import ACO.week2.homework.library.controller.interfaces.ILibraryReaderController;
import ACO.week2.homework.library.model.Library;
import ACO.week2.homework.library.model.Reader;
import ACO.week2.homework.library.model.printed_editions.Genre;
import ACO.week2.homework.library.model.printed_editions.PrintedEdition;
import ACO.week2.homework.library.utils.Utils;

import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by v21k on 01.02.17.
 */
public class MenuPrintedEditions {

    private static Comparator[] comparators = {new PEByNameComparator(), new PEByAuthorComparator(), new PEByYearComparator()};
    private static Scanner sc = new Scanner(System.in);

    // 2
    public static boolean showAllPE(ILibraryPEController lp) {

        int choice = Utils.getComparatorChoice();

        if (choice < 1 || choice > comparators.length) {
            // default
            System.out.println(lp.showAllPrintedEditionsInLibrary(comparators[0]));
        } else {
            System.out.println(lp.showAllPrintedEditionsInLibrary(comparators[choice - 1]));
        }
        return true;
    }

    // 3
    public static boolean addPrintedEdition(ILibraryPEController lp) {
        System.out.println("Enter a name: ");
        String name = sc.nextLine();
        System.out.println("Enter a genre - list of all genres below (enter a number): ");
        System.out.println(Genre.showAll());
        int genre = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter an author: ");
        String author = sc.nextLine();
        System.out.println("Enter a year: ");
        String year = sc.nextLine();

        if (lp.addPrintedEdition(lp.createNewPrintedEdition(name, genre, author, year))) {
            System.out.println("Done!\n");
            return true;
        }
        System.out.println("Wrong input.\n");
        return false;
    }

    // 5
    public static boolean givePEToReader(Library library, ILibraryPEController lp, ILibraryReaderController lr) {

        System.out.println("Choose PE (number)");
        System.out.println(Utils.showPrintedEditions(library.getPrintedEditionsInLibrary()));
        int choicePE = sc.nextInt();

        int choiceReader = Utils.getReaderChoice(lr);

        if (choicePE >= 1 && choicePE <= library.getPrintedEditionsInLibrary().size()
                && choiceReader >= 1 && choiceReader <= library.getReaders().size()) {

            return lp.givePrintedEditionToReader((Reader) library.getReaders().get(choiceReader - 1),
                    (PrintedEdition) library.getPrintedEditionsInLibrary().get(choicePE - 1));
        }
        System.out.println("Wrong input!");
        return false;
    }

    // 6
    public static boolean showPEReaderTook(ILibraryPEController lp) {

        int choice = Utils.getComparatorChoice();

        if (choice < 1 || choice > comparators.length) {
            // default
            System.out.println(lp.showPrintedEditionAllReaders(comparators[0]));
        } else {
            System.out.println(lp.showPrintedEditionAllReaders(comparators[choice - 1]));
        }
        return true;
    }

    // 7
    public static boolean showCertainReaderPEs(Library library, ILibraryPEController lp, ILibraryReaderController lr) {

        int choice = Utils.getReaderChoice(lr);

        if (choice >= 1 && choice <= library.getReaders().size()) {
            System.out.println(lp.showPrintedEditionCertainReader((Reader) library.getReaders().get(choice - 1),
                    comparators[0]));
            return true;
        }
        return false;
    }

    // 9
    public static boolean showCertainAuthorPEs(ILibraryPEController lp) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter author's name: ");
        String author = sc.nextLine();

        System.out.println(lp.showCertainAuthorPrintedEditions(author, comparators[0]));
        return true;
    }

    // 10
    public static boolean showCertainYearPEs(ILibraryPEController lp) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a year: ");
        int year = sc.nextInt();

        System.out.println(lp.showCertainYearPrintedEditions(year, comparators[0]));
        return true;
    }

    // 11
    public static boolean findPEByKeywords(ILibraryPEController lp) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter keywords (with ', ' as delimiter) : ");
        System.out.println("Example: 'some, key, words'");
        String keywords = sc.nextLine();

        System.out.println(lp.findPrintedEditionByKeywords(keywords, comparators[0]));
        return true;
    }
}
