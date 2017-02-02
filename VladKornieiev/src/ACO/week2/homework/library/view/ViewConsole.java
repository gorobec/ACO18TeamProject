package ACO.week2.homework.library.view;

import ACO.week2.homework.library.controller.*;
import ACO.week2.homework.library.model.Library;
import ACO.week2.homework.library.utils.Utils;
import ACO.week2.homework.library.view.menu.*;

import java.util.Scanner;

/**
 * Created by v21k on 31.01.17.
 */
public class ViewConsole {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Library library = new Library();
        Utils.initLibrary(library);

        LibraryReaderController lr = new LibraryReaderController(library);
        LibraryPEController lp = new LibraryPEController(library);

        boolean exit = false;

        while (!exit) {

            String choice = startMenu();

            switch (choice) {
                case "1":
                    MenuReader.showAllReaders(lr);
                    break;
                case "2":
                    MenuPrintedEditions.showAllPE(lp);
                    break;
                case "3":
                    MenuPrintedEditions.addPrintedEdition(lp);
                    break;
                case "4":
                    MenuReader.addReader(lr);
                    break;
                case "5":
                    MenuPrintedEditions.givePEToReader(library, lp, lr);
                    break;
                case "6":
                    MenuPrintedEditions.showPEReaderTook(lp);
                    break;
                case "7":
                    MenuPrintedEditions.showCertainReaderPEs(library, lp, lr);
                    break;
                case "8":
                    MenuReader.addReaderToBlackList(library, lr);
                    break;
                case "9":
                    MenuPrintedEditions.showCertainAuthorPEs(lp);
                    break;
                case "10":
                    MenuPrintedEditions.showCertainYearPEs(lp);
                    break;
                case "11":
                    MenuPrintedEditions.findPEByKeywords(lp);
                    break;
                case "0":
                    System.out.println("Bye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Wrong input!");
            }

        }

    }

    private static String startMenu() {
        System.out.println("Welcome to our library! What do you want to do?");
        System.out.println("1. Show all readers in Library");
        System.out.println("2. Show available printed editions");
        System.out.println("3. Add PE to library");
        System.out.println("4. Add reader to library");
        System.out.println("5. Give PE to the reader");
        System.out.println("6. Show PE which readers took");
        System.out.println("7. Show certain reader PEs");
        System.out.println("8. Add reader to blacklist");
        System.out.println("9. Show certain author PEs");
        System.out.println("10. Show ceretain year PEs");
        System.out.println("11. Find PE by keyword(s)");
        System.out.println("0. EXIT");
        System.out.println("Please, enter a number.");
        return sc.nextLine();
    }
}
