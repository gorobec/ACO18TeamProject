package week2.library;


import week2.library.comparators.EditionsByName;
import week2.library.comparators.ReaderNameSorting;
import week2.library.editions.PrintEdition;
import week2.library.readers.Reader;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;

public class Library {
    private String libName;
    private String location;

    private ArrayList<PrintEdition> editions = new ArrayList<>();
    private ArrayList<Reader> readers = new ArrayList<>();

    public Library() {
        libName = "Good Library";
        location = "somewhere";
    }

    public Library(String libName, String location) {
        this.libName = libName;
        this.location = location;
    }

    // sorting list
    public ArrayList sortList(ArrayList list, Comparator comparator) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (comparator.compare(list.get(i), list.get(j)) > 0) {
                    Object temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        return list;
    }

    // 1) посмотреть список читателей (в отсортированном виде)
    public ArrayList readersList() {
        sortList(readers, new ReaderNameSorting());
        for (int i = 0; i < readers.size(); i++) {
            System.out.printf("%s %s\n", readers.get(i).getName(),
                    readers.get(i).getSurname());
        }
        return readers;
    }

    // 2) посмотреть список доступных конкретных печатных изданий (в отсортированном виде)
    public ArrayList editionsInLibrary() {
        sortList(editions, new EditionsByName());
        for (int i = 0; i < editions.size(); i++) {
            System.out.printf("\"%s\", author -> %s\n",
                    editions.get(i).getName(), editions.get(i).getAuthor());
        }
        return editions;
    }

    // 3) добавить печатное издание в библиотеку
    public boolean addPrintEdition(PrintEdition edition) {
        if (edition == null) {
            return false;
        }
        return editions.add(edition);
    }

    // 4) добавить читателя в список читателей
    public boolean addReaderToList(Reader reader) {
        if (reader == null) {
            return false;
        }
        return readers.add(reader);
    }

    // 9) посмотреть печатные издания конкретного автора
    public ArrayList showAuthorBooks(String author) {
        sortList(editions, new EditionsByName());
        for (int i = 0; i < editions.size(); i++) {
            if (editions.get(i).getAuthor().equalsIgnoreCase(author)) {
                System.out.printf("%s --> \"%s\"\n", editions.get(i).getAuthor(), editions.get(i).getName());
            }
        }
        return editions;
    }

    // 11) посмотреть печатные издания конкретного года
    public ArrayList showBooksByYear(int year) {
        sortList(editions, new EditionsByName());
        for (int i = 0; i < editions.size(); i++) {
            if (editions.get(i).getYear() == year) {
                System.out.printf("%d --> \"%s\" %s\n", editions.get(i).getYear(),
                        editions.get(i).getName(), editions.get(i).getAuthor());
            }
        }
        return editions;
    }
}