package ACO.week2.homework.library.controller;

import ACO.week2.homework.library.comparators.ReaderByNameComparator;
import ACO.week2.homework.library.controller.interfaces.ILibraryReaderController;
import ACO.week2.homework.library.model.*;
import ACO.week2.homework.library.utils.Utils;

import java.util.Arrays;

/**
 * Created by v21k on 31.01.17.
 */
public class LibraryReaderController implements ILibraryReaderController {
    // todo interfaces
    private Library library;

    public LibraryReaderController(Library library) {
        this.library = library;
    }

    public Reader createNewReader(String name) {
        // validation
        if (name.matches("^\\D+$")) {
            Reader reader = new Reader(name);
            return reader;
        }
        return null;
    }

    public boolean addReader(Reader reader) {
        return library.addReader(reader);
    }

    public boolean addReaderToBlackList(Reader reader) {
        reader.setInBlackList(true);
        return true;
    }

    public String showAllReaders() {

        if (library.getReaders().size() == 0) {
            return "No readers";
        }

        Reader[] readers = Utils.readersToArray(library.getReaders());
        Arrays.sort(readers, new ReaderByNameComparator());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < readers.length; i++) {
            sb.append(i + 1).append(": ").append(readers[i].toString()).append("\n");
        }
        return sb.toString();
    }
}
