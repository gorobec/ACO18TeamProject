package oop.library.controller;

import oop.library.model.PrintedEdition;
import oop.library.model.Reader;
import oop.weak1.task_7_arrayList.MyArrayList;
import oop.weak1.task_7_arrayList.MyList;

import java.util.List;

/**
 * Created by fmandryka on 04.02.2017.
 */
public class Controller {

    Library lib;

    public Controller() {
        Library.getInstance();
    }

    public MyList<Reader> readersList() {
        return (MyList<Reader>) lib.getReaders();
    }

    public MyList<PrintedEdition> getFullPrintEditList() {
        return (MyList<PrintedEdition>) lib.getPrintEditInStock();
    }

    public boolean addReader(Reader reader) {
        return lib.getReaders().add(reader);
    }

    public boolean addPrintedEdition(PrintedEdition printEdit) {
        return lib.getPrintEditInStock().add(printEdit);
    }

    public MyList<PrintedEdition> getAvailablePrintEditList() {

        MyList<PrintedEdition> availablePrEd = lib.getPrintEditInStock();
        MyList<PrintedEdition> availablePrEd = new MyArrayList<>();

        for (int i = 0; i < lib.getPrintEditInStock().size(); i++) {
            if (lib.getPrintEditInStock().get(i).isAvailable()) {
                availablePrEd.add(lib.getPrintEditInStock().get(i));
            }
        }

        return availablePrEd;
    }

}