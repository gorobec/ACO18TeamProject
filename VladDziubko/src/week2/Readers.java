package week2.library.readers;

import week2.library.comparators.NameSorting;

import java.util.ArrayList;
import java.util.Comparator;

public class Readers {
    private ArrayList<Reader> readers = new ArrayList<>();

    public Readers() {
    }

    // sorting list
    private ArrayList<Reader> sortList(ArrayList<Reader> list, Comparator comparator) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (comparator.compare(list.get(i), list.get(j)) > 0) {
                    Reader temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        return list;
    }
    // при добавлении второго читателя вывожу список на экран и выводит два раза первого юзера, потом 2-го
    // 1) посмотреть список читателей (в отсортированном виде)
    public ArrayList<Reader> readersList() {
        sortList(readers, new NameSorting());
        for (int i = 0; i < readers.size(); i++) {
            System.out.printf("%s %s\n", readers.get(i).getName(),
                    readers.get(i).getSurname());
        }
        return readers;
    }

    // 4) добавить читателя в список читателей
    public boolean addReaderToList(String name, String surname) {
        return readers.add(new Reader(name, surname));
    }

}
