package week2.library.readers;


import week2.library.editions.PrintEdition;

import java.util.ArrayList;

public class Reader {
    private String name;
    private String surname;
    private boolean inBlackList;
    private int currentBookCount = 0;
    // Подумать какие константы можно добавить в вашу программу "Библиотека",
    // при наличии таких - реализуйте вашу задумку.
    private final int MAX_BOOKS_PER_READER = 3;
    private ArrayList<PrintEdition> readerTakenEditions = new ArrayList<>();

    public Reader() {
    }

    public Reader(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Reader(String name, String surname, boolean inBlackList) {
        this.name = name;
        this.surname = surname;
        this.inBlackList = inBlackList;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getCurrentBookCount() {
        return currentBookCount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (o.getClass() != this.getClass()) {
            return false;
        }
        Reader reader = (Reader) o;
        return name.equals(reader.name) && surname.equals(reader.surname);
    }

    public String toString() {
        return String.format("%s %s, taken books -> %d", name, surname, currentBookCount);
    }

    // 5) выдать печатное издание читателю.
    // Читателю запрещается брать больше 3-х печатных изданий.

    public boolean takePrintEdition(PrintEdition printEdition) {
        if (currentBookCount < MAX_BOOKS_PER_READER && !inBlackList) {
            currentBookCount++;
            return readerTakenEditions.add(printEdition);
        }
        return false;
    }

    // 7) посмотреть список печатных изданий, которые находятся у конкретного читателя
    public ArrayList showTakenBooks() {
        for (PrintEdition edition : readerTakenEditions) {
            System.out.printf("\"%s\", author -> %s\n", edition.getName(),
                    edition.getAuthor());
        }
        return readerTakenEditions;
    }

    // remove PE
    public boolean giveBackPrintEdition(Reader reader, PrintEdition printEdition) {
        if (readerTakenEditions.contains(printEdition)) {
            currentBookCount--;
            return readerTakenEditions.remove(printEdition);
        }
        return false;
    }

}
