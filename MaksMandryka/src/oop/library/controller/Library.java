package oop.library.controller;

import oop.library.model.PrintedEdition;
import oop.library.model.Reader;
import oop.weak1.task_7_arrayList.MyArrayList;
import oop.weak1.task_7_arrayList.MyList;

/**
 * Created by fmandryka on 31.01.2017.
 */
public class Library {

    private static Library lb;

    private MyArrayList<Reader> readers;
    private MyArrayList<PrintedEdition> printEditions;

    private int lastReaderId = getMaxReaderId();
    private int lastEditId = getMaxEditId();

    private Library() {
    }

    ;

    public static Library getInstance() {
        if (Library.lb == null) {
            lb = new Library();
        }
        return lb;
    }

    public MyArrayList<Reader> getReaders() {
        return readers;
    }

    public MyArrayList<PrintedEdition> getPrintEditAll() {
        return printEditions;
    }

    public boolean addReader(Reader reader) {
        if (reader != null && !readers.contains(reader)) {
            reader.setId(++lastReaderId);
            return readers.add(reader);
        }
        return false;
    }

    public boolean addPrintedEdition(PrintedEdition printEdit) {
        if (printEdit != null) {
            printEdit.setId(++lastEditId);
            return printEditions.add(printEdit);
        }
        return false;
    }

    public MyList<PrintedEdition> getAvailablePrintEditList() {

        MyList<PrintedEdition> availablePrEd = new MyArrayList<>();

        for (int i = 0; i < printEditions.size(); i++) {
            if (printEditions.get(i).isAvailable()) {
                availablePrEd.add(printEditions.get(i));
            }
        }

        return availablePrEd;
    }

    public boolean givePrintEdit(Reader reader, PrintedEdition printEdit) {
        if (readers.contains(reader) &&  && printEditions.contains(printEdit)) {
            if (printEditions.get(printEditions.indexOf(printEdit)).isAvailable())
        }
    }

    private int getMaxReaderId() {

        int id = 0;
        for (int i = 0; i < readers.size(); i++) {
            if (readers.get(i).getId() > id) {
                id = readers.get(i).getId();
            }
        }
        return id;
    }

    private int getMaxEditId() {
        int id = 0;
        for (int i = 0; i < printEditions.size(); i++) {
            if (printEditions.get(i).getId() > id) {
                id = printEditions.get(i).getId();
            }
        }
        return id;
    }


    public boolean addReaderToBlackL(Reader reader) {
        if (reader != null && !readers.contains(reader)) {

            readers.get(readers.indexOf(reader)).setBlackListed(true);
            return true;

        }
        return false;
    }

}
