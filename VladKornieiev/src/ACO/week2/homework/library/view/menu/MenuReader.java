package ACO.week2.homework.library.view.menu;

import ACO.week2.homework.library.controller.interfaces.ILibraryReaderController;
import ACO.week2.homework.library.model.Library;
import ACO.week2.homework.library.model.Reader;

import java.util.Scanner;

/**
 * Created by v21k on 01.02.17.
 */
public class MenuReader {

    // 1
    public static boolean showAllReaders(ILibraryReaderController lr) {
        System.out.println(lr.showAllReaders());
        return true;
    }

    // 4
    public static boolean addReader(ILibraryReaderController lr) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a name: ");
        String name = sc.next();

        if (lr.addReader(lr.createNewReader(name))) {
            System.out.println("Done!\n");
            return true;
        }
        return false;
    }

    // 8
    public static boolean addReaderToBlackList(Library library, ILibraryReaderController lr) {
        int choice = MenuUtils.getReaderChoice(lr);
        if (choice >= 1 && choice <= library.getReaders().size()) {
            System.out.println("Done!\n");
            return lr.addReaderToBlackList(((Reader) library.getReaders().get(choice - 1)));
        }
        System.out.println("Wrong input\n");
        return false;
    }
}
