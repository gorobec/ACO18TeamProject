package library.controller.interfaces;

import library.model.PrintEdition;
import library.model.Reader;

/**
 * Created by Nastia on 31.01.17.
 */
public interface AddItemAble {

    boolean addReader(Reader reader);
    boolean addPrintEdition(PrintEdition printEdition);
}
