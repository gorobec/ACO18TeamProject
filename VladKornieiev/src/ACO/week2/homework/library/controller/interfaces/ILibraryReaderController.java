package ACO.week2.homework.library.controller.interfaces;

import ACO.week2.homework.library.model.Reader;

/**
 * Created by v21k on 31.01.17.
 */
public interface ILibraryReaderController {

    boolean addReader(Reader reader);

    boolean addReaderToBlackList(Reader reader);

    String showAllReaders();

    Reader createNewReader(String name);

}
