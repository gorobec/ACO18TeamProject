package library.controler;

import data_structures.MyArrayList;
import library.model.*;
import library.comparators.*;
import java.util.Comparator;

/**
 * Created by ksyashka on 30.01.2017.
 */
public class Library {
    MyArrayList editions;
    MyArrayList readers;
    MyArrayList blackList;

    public Library() {
        editions = new MyArrayList();
        readers = new MyArrayList();
        blackList = new MyArrayList();
    }

    public Reader getReaderById(int id) {
        Reader reader;
        for (int i = 0; i < readers.size(); i++) {
            reader = (Reader) readers.get(i);
            if (reader.getId() == id) return reader;
        }
        return null;
    }

    public boolean addEdition(Edition edition) {
        editions.add(edition);
        return true;
    }

    public boolean addReader(String name, String surname, int year, int month, int day) {
        int id = readers.size() + 1;
        Reader reader = new Reader(id, name, surname, year, month, day);
        readers.add(reader);
        return true;
    }

    public boolean giveEditionToReader(Edition edition, int id) {
        if (getReaderById(id) == null || readerInBlacklist(getReaderById(id)) || !edition.isAvaible()) return false;
        edition.setNumber(edition.getNumber() - 1);
        return getReaderById(id).addEdition(edition);
    }

    public boolean readerInBlacklist(Reader reader) {
        return blackList.contains(reader);
    }

    public boolean addReaderToBlackList(int id) {
        blackList.add(getReaderById(id));
        return true;
    }

    public void showReaders() {
        sortReaders();
        for (int i = 0; i < readers.size(); i++)
            System.out.println(readers.get(i));
    }

    public void showEditions() {
        sortEditions();
        for (int i = 0; i < editions.size(); i++) {
            Edition edition = (Edition) editions.get(i);
            if (edition.isAvaible())
                System.out.println(editions.get(i));
        }
    }

    public void showEditions(int year) {
        for (int i = 0; i < editions.size(); i++) {
            Edition edition = (Edition) editions.get(i);
            if (edition.getYear() == year)
                System.out.println(editions.get(i));
        }
    }

    public void showEditions(String name) {
        sortEditions();
        for (int i = 0; i < editions.size(); i++) {
            Edition edition = (Edition) editions.get(i);
            if (edition.getName().contains(name))
                System.out.println(editions.get(i));
        }
    }

    public void showEditionsAtReaders() {
        sortReaders();
        for (int i = 0; i < readers.size(); i++) {
            System.out.println(readers.get(i));
            Reader currentReader = (Reader) readers.get(i);
            currentReader.showEditions();
        }
    }

    public void showEditionsAtReaders(Reader reader) {
        System.out.println(reader);
        reader.showEditions();
    }

    public void sortReaders() {
        sortReadersByComparator(new NameReadersComparator());
        sortReadersByComparator(new SurnameComparator());
    }

    public void sortReadersByComparator(Comparator comparator) {
        Reader temp;
        for (int i = readers.size() - 1; i > 0; i--)
            for (int j = 0; j < i; j++)
                if ((comparator.compare((Reader) readers.get(j), (Reader) readers.get(j + 1)) > 0)) {
                    temp = (Reader) readers.get(j + 1);
                    readers.set(j + 1, readers.get(j));
                    readers.set(j, temp);
                }
    }

    public void sortEditions() {
        sortEditionsByComparator(new NameEditionsComparator());
        sortEditionsByComparator(new AuthorComparator());
        sortEditionsByComparator(new TypeEditionsComparator());
    }

    public void sortEditionsByComparator(Comparator comparator) {
        Edition temp;
        for (int i = editions.size() - 1; i > 0; i--)
            for (int j = 0; j < i; j++)
                if ((comparator.compare((Edition) editions.get(j), (Edition) editions.get(j + 1)) > 0)) {
                    temp = (Edition) editions.get(j + 1);
                    editions.set(j + 1, editions.get(j));
                    editions.set(j, temp);
                }

    }


}
