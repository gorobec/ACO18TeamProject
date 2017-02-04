package ACO.week2.homework.library.view.menu;

import ACO.week2.homework.library.controller.interfaces.ILibraryReaderController;
import ACO.week2.homework.library.model.Library;
import ACO.week2.homework.library.utils.Utils;
import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by v21k on 02.02.17.
 */
public class MenuUtils {
    private static final Gson GSON = new Gson();
    private static final Path PATH = Paths.get("VladKornieiev/src/ACO/week2/homework/library/view/menu/files/library.txt");
    private static Scanner sc = new Scanner(System.in);

    public static Library loadLibrary() throws IOException {
        return GSON.fromJson(Files.readAllLines(PATH)
                .stream()
                .collect(Collectors.joining()), Library.class);
    }

    public static void saveLibrary(Library library) throws IOException {
        String toJson = GSON.toJson(library);
        Files.write(PATH, toJson.getBytes(), StandardOpenOption.CREATE);
    }

    public static void clearLibrary() throws IOException {
        Files.delete(PATH);
        Library library = new Library();
        saveLibrary(library);
    }

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
