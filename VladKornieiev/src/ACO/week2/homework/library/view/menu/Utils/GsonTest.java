package ACO.week2.homework.library.view.menu.Utils;

import ACO.week2.homework.library.comparators.PEByNameComparator;
import ACO.week2.homework.library.controller.LibraryPEController;
import ACO.week2.homework.library.model.Library;
import ACO.week2.homework.library.utils.Utils;
import com.google.gson.Gson;

/**
 * Created by v21k on 03.02.17.
 */
public class GsonTest {
    public static void main(String[] args) {
        Gson gson = new Gson();
        Library library = new Library();
        Utils.initLibrary(library);

        String toJson = gson.toJson(library);
        System.out.println(toJson);

        Library readLibrary = gson.fromJson(toJson, Library.class);

        LibraryPEController lp = new LibraryPEController(readLibrary);

        System.out.println(lp.showAllPrintedEditionsInLibrary(new PEByNameComparator()));

    }
}
