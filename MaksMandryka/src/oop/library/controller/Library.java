package oop.library.controller;

import oop.library.model.Edition;
import oop.library.model.PrintedEdition;
import oop.library.model.Reader;
import oop.dataStructures.MyArrayList;
import oop.dataStructures.MyList;

import java.util.Calendar;
import java.util.Comparator;

/**
 * Created by fmandryka on 31.01.2017.
 */
public class Library {

    private static Library lb;

    private MyArrayList<Reader> readers = new MyArrayList<>();
    private MyArrayList<PrintedEdition> printEditions = new MyArrayList<>();

    private int lastReaderId = getMaxReaderId();
    private int lastEditId = getMaxEditId();

    private Library() {
    }


    public static Library getInstance() {
        if (Library.lb == null) {
            lb = new Library();
        }
        return lb;
    }

    public void close() {
        lb = null;
    }

    //1. посмотреть список читателей
    public MyArrayList<Reader> getReaders() {
        Comparator<? super Reader> c = new Reader.ReaderCompar();
        readers.sort(c);
        return readers;
    }

    public MyArrayList<PrintedEdition> getPrintEditAll() {
        return printEditions;
    }

    //4. добавить читателя в список читателей
    public boolean addReader(Reader reader) {
        if (reader != null && !readers.contains(reader)) {
            reader.setId(++lastReaderId);
            return readers.add(reader);
        }
        return false;
    }

    //3. добавить печатное издание в библиотеку
    public boolean addPrintedEdition(PrintedEdition printEdit) {
        if (printEdit != null) {
            printEdit.setId(++lastEditId);
            return printEditions.add(printEdit);
        }
        return false;
    }

    //2. посмотреть список доступных конкретных печатных изданий
    public MyList<PrintedEdition> getAvailablePrintEditList() {

        MyList<PrintedEdition> availablePrEd = new MyArrayList<>();

        for (int i = 0; i < printEditions.size(); i++) {
            if (printEditions.get(i).isAvailable()) {
                availablePrEd.add(printEditions.get(i));
            }
        }

        Comparator<? super Edition> c = new Edition.EditionCompar();
        availablePrEd.sort(c);

        return availablePrEd;
    }

    //5. выдать печатное издание читателю (если книга есть в наличии).
    //Читателю запрещается брать больше 3-х печатных изданий.
    public boolean givePrintEdit(Reader reader, PrintedEdition printEdit) {

        if (readers.contains(reader) && printEditions.contains(printEdit)) {

            PrintedEdition pE = printEditions.get(printEditions.indexOf(printEdit));
            Reader rd = readers.get(readers.indexOf(reader));

            if (!rd.isBlackListed() && pE.isAvailable() && rd.getBooksTaken().size() < Reader.BOOKS_LIMIT) {
                pE.setReaderId(rd.getId());
                rd.getBooksTaken().add(pE);
                return true;
            }
        }

        return false;
    }

    private int getMaxReaderId() {

        int id = 0;
        if (readers.size()>0) {
            for (int i = 0; i < readers.size(); i++) {
                if (readers.get(i).getId() > id) {
                    id = readers.get(i).getId();
                }
            }
        }
        return id;
    }

    private int getMaxEditId() {
        int id = 0;
        if (printEditions.size()>0) {
            for (int i = 0; i < printEditions.size(); i++) {
                if (printEditions.get(i).getId() > id) {
                    id = printEditions.get(i).getId();
                }
            }
        }
        return id;
    }


    //8. добавить читателя в черный список (ему нельзя выдавать печатные издания)
    public boolean addReaderToBlackL(Reader reader) {
        if (reader != null && !readers.contains(reader)) {

            readers.get(readers.indexOf(reader)).setBlackListed(true);
            return true;

        }
        return false;
    }

    //6. посмотреть список печатных изданий, которые находятся у читателей
    public MyList<PrintedEdition> getTakenPrintEditList() {

        MyList<PrintedEdition> TakenPrEd = new MyArrayList<>();

        for (int i = 0; i < printEditions.size(); i++) {
            if (!printEditions.get(i).isAvailable()) {
                TakenPrEd.add(printEditions.get(i));
            }
        }

        Comparator<? super Edition> c = new Edition.EditionCompar();
        TakenPrEd.sort(c);

        return TakenPrEd;
    }

    //7. посмотреть список печатных изданий, которые находятся у конкретного читателя
    public MyList<PrintedEdition> getTakenPrintEditList(Reader reader) {

        if (readers.contains(reader)) {
            Comparator<? super Edition> c = new Edition.EditionCompar();
            readers.get(readers.indexOf(reader)).getBooksTaken().sort(c);
            return readers.get(readers.indexOf(reader)).getBooksTaken();
        }

        throw new IllegalArgumentException("No such user!");
    }

    //11. посмотреть печатные издания конкретного года
    public MyList<PrintedEdition> getPrintEditOfYear(int year) {

        MyList<PrintedEdition> PrEdFound = new MyArrayList<>();

        for (int i = 0; i < printEditions.size(); i++) {
            if (printEditions.get(i).getEditionDate().get(Calendar.YEAR) == year) {
                PrEdFound.add(printEditions.get(i));
            }
        }

        Comparator<? super Edition> c = new Edition.EditionCompar();
        PrEdFound.sort(c);

        return PrEdFound;
    }


    //12. найти печатное издание по названию (ключевым словам)
    public MyList<PrintedEdition> getPrintEditByMatch(String... keywords) {

        MyList<PrintedEdition> PrEdFound = new MyArrayList<>();
        boolean found = false;

        for (int i = 0; i < printEditions.size(); i++) {
            for (String key : keywords) {
                if (printEditions.get(i).getName().contains(key.toString())) {
                    found = true;
                }
            }

            if (found) {
                PrEdFound.add(printEditions.get(i));
                found=false;
            }

        }

        Comparator<? super Edition> c = new Edition.EditionCompar();
        PrEdFound.sort(c);

        return PrEdFound;
    }


    //9. посмотреть печатные издания конкретного автора
    public MyList<PrintedEdition> getPrintEditByAuthor(String author) {

        MyList<PrintedEdition> PrEdFound = new MyArrayList<>();
        boolean found = false;

        for (int i = 0; i < printEditions.size(); i++) {
            for (int j = 0; j < printEditions.get(i).getAuthorName().length; j++) {
                if (printEditions.get(i).getAuthorName()[j].equals(author)) {
                    found = true;
                }
            }

            if (found) {
                PrEdFound.add(printEditions.get(i));
                found = false;
            }

        }

        Comparator<? super Edition> c = new Edition.EditionCompar();
        PrEdFound.sort(c);

        return PrEdFound;
    }


}
