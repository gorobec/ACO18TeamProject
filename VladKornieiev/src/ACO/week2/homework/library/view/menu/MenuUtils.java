package ACO.week2.homework.library.view.menu;

import ACO.week2.homework.library.controller.interfaces.ILibraryReaderController;

import java.util.Scanner;

/**
 * Created by v21k on 02.02.17.
 */
public class MenuUtils {

    private static Scanner sc = new Scanner(System.in);

    public static int getComparatorChoice() {
        System.out.println("Choose sort comparator: ");
        System.out.println("1. By name");
        System.out.println("2. By author");
        System.out.println("3. By year");
        int i = sc.nextInt();
        return i;
    }

    public static int getReaderChoice(ILibraryReaderController lr) {
        System.out.println("Choose reader (number)");
        System.out.println(lr.showAllReaders());
        int i = sc.nextInt();
        return i;
    }
}
