package library.controller;

import data_structures.MyArrayList;
import library.controller.interfaces.AddItemAble;
import library.controller.interfaces.Showable;
import library.model.Author;
import library.model.PrintEdition;
import library.model.Reader;
import library.model.comparators.ComparatorPrintEditionByName;
import library.model.comparators.ComparatorReaderByName;

import java.util.Comparator;

/**
 * Created by anastasiia.shvetsova on 1/30/2017.
 */
public class Library implements AddItemAble, Showable {
    private MyArrayList readers;
    private MyArrayList printEditions;
    private MyArrayList printEditionsHasReaders;
    private MyArrayList blackLists;
    private  int countPrintEditions = 0;
    private  int counReaderPrintEditions;
    private  int countReaders = 0;

    Comparator comparatorPrintEditionsByName = new ComparatorPrintEditionByName();
    Comparator comparatorByName = new ComparatorReaderByName();

    public Library() {
        this.readers = new MyArrayList();
        this.printEditions = new MyArrayList();
        this.printEditionsHasReaders = new MyArrayList();
        this.blackLists = new MyArrayList();
    }

    public MyArrayList getBlackLists() {
        return blackLists;
    }

    public boolean addReader(Reader reader) {
        readers.add(reader);
        countReaders++;
        return true;
    }

    public boolean addPrintEdition(PrintEdition printEdition) {
        printEditions.add(printEdition);
        countPrintEditions++;
        return true;
    }

    public String showReaders() {
        sortReaders(comparatorByName);
        System.out.println("Readers:");
        return readers.toString();
    }

    public String showPrinEdtitions() {
        sortPrintEditions(comparatorPrintEditionsByName, countPrintEditions, printEditions);
        System.out.println("Print Editions:");
        return printEditions.toString();
    }

    public boolean isPrintEditionAvailable(PrintEdition printEdition) {
        return printEditions.contains(printEdition);
    }

    public boolean givePrintEditionForReader(PrintEdition printEdition, Reader reader) {
        if (checkReader(reader)) return false;
        if (!isPrintEditionAvailable(printEdition)) return false;
        if (counReaderPrintEditions == 3 || counReaderPrintEditions > 3) return false;
        printEditionsHasReaders.add(printEdition);
        counReaderPrintEditions++;
        PrintEdition tmpPrintEdition = null;
        for (int i = 0; i < printEditions.size(); i++) {
            if ((printEditions.get(i) != null)) {
                if (printEditions.get(i).equals(printEdition)) {
                    tmpPrintEdition = (PrintEdition) printEditions.get(i);
                }
            }
        }
        for (int i = 0; i < readers.size(); i++) {
            if ((readers.get(i) != null)) {
                if (readers.get(i).equals(reader)) {
                    Reader tmpReader = (Reader) readers.get(i);
                    tmpReader.addPrintEditionForReader(tmpPrintEdition);
                    return true;
                }
            }

        }
        return false;
    }

    public String showReadersPrinEdtitions() {
        sortPrintEditions(comparatorPrintEditionsByName, counReaderPrintEditions, printEditionsHasReaders);
        System.out.println("Reader's print editions:");
        return printEditionsHasReaders.toString();
    }

    public String showCurrentReaderPrinEdtitions(Reader reader) {
        sortPrintEditions(comparatorPrintEditionsByName, reader.getCountPrintEditions(), reader.getReaderPrintEditions());
        System.out.println(reader.getName() + "'s print editions:");
        return reader.showReaderPrintEditions();
    }

    public boolean addReaderToBlackList(Reader reader) {
        if (!checkReader(reader)) {
            reader.setInBlackList(true);
            blackLists.add(reader);
            return true;
        }
        return false;
    }

    public boolean checkReader(Reader reader) {
        return reader.getIsInBlackList();
    }

    public String showPrintEditionCurrentAuthor(Author author) {
        MyArrayList printEditionsCurrentAuthor = new MyArrayList();
        sortPrintEditions(comparatorPrintEditionsByName, countPrintEditions, printEditions);
        for (int i = 0; i < printEditions.size(); i++) {
            PrintEdition tmp = (PrintEdition) printEditions.get(i);
            if (tmp.getAuthor().equals(author)) {
                printEditionsCurrentAuthor.add(tmp);
            }

        }
        return printEditionsCurrentAuthor.toString();
    }

    public String showPrintEditionCurrentYear(int year) {
        MyArrayList printEditionsCurrentYear = new MyArrayList();
        sortPrintEditions(comparatorPrintEditionsByName, countPrintEditions, printEditions);
        for (int i = 0; i < printEditions.size(); i++) {
            PrintEdition tmp = (PrintEdition) printEditions.get(i);
            if (tmp.getYear() == year) {
                printEditionsCurrentYear.add(tmp);
            }

        }
        return printEditionsCurrentYear.toString();
    }

    public void sortReaders(Comparator comparator) {
        for (int i = countReaders - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                int res = comparator.compare(readers.get(j), readers.get(j + 1));
                if (res > 0) {
                    Reader tmp = (Reader) readers.get(j);
                    readers.set(j, readers.get(j + 1));
                    readers.set(j + 1, tmp);
                }
            }
        }
    }

    public void sortPrintEditions(Comparator comparator, int counter, MyArrayList myArrayList) {
        for (int i = counter - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                int res = comparator.compare(myArrayList.get(j), myArrayList.get(j + 1));
                if (res > 0) {
                    PrintEdition tmp = (PrintEdition) myArrayList.get(j);
                    myArrayList.set(j, myArrayList.get(j + 1));
                    myArrayList.set(j + 1, tmp);
                }
            }
        }
    }

    public boolean findPrintEdition(String str) {
        if (str.equals("")) return false;
        for (int i = 0; i < countPrintEditions; i++) {
            PrintEdition tmp = (PrintEdition) printEditions.get(i);
            if (tmp.getName().toLowerCase().contains(str.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

}
