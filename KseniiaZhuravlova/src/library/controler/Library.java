package library.controler;

import data_structures.MyArrayList;
import library.model.*;
import library.comparators.*;

import java.util.Comparator;

/**
 * Created by ksyashka on 30.01.2017.
 */
public class Library {
    MyArrayList<Edition> editions;
    MyArrayList<Reader> readers;

    public Library() {
        editions = new MyArrayList<>();
        readers = new MyArrayList<>();
    }

    private Reader getReaderById(int id) {
        Reader reader;
        for (int i = 0; i < readers.size(); i++) {
            reader = readers.get(i);
            if (reader != null && reader.getId() == id) return reader;
        }
        return null;
    }

    public boolean addEdition(Edition edition) {
        if (edition == null) return false;
        int index = duplicateEdition(edition);
        if (index == -1) editions.add(edition);
        else {
            Edition tempEdition = editions.get(index);
            tempEdition.setNumber(tempEdition.getNumber() + edition.getNumber());
        }
        return true;
    }

    public int duplicateEdition(Edition edition) {
        for (int i = 0; i < editions.size(); i++)
            if (edition.equals(editions.get(i))) {
                return i;
            }
        return -1;
    }

    public boolean addReader(String name, String surname, int year, int month, int day) {
        int id = readers.size() + 1;
        Reader reader = new Reader(id, name, surname, year, month, day);
        readers.add(reader);
        return true;
    }

    public boolean giveEditionToReader(Edition e, int id) {
        Reader reader = getReaderById(id);
        Edition edition = findEdition(e);
        if (reader == null || edition == null || !edition.isAvailable()) return false;
        boolean result = reader.addEdition(edition);
        if (result) edition.setNumber(edition.getNumber() - 1);
        return result;
    }

    private Edition findEdition(Edition edition) {
        if (edition == null) return null;
        Edition findEdition;
        for (int i = 0; i < editions.size(); i++) {
            findEdition = editions.get(i);
            if (edition.equals(findEdition)) return findEdition;
        }
        return null;
    }

    public boolean addReaderToBlackList(int id) {
        Reader reader = getReaderById(id);
        if (reader == null) return false;
        reader.setInBlackList(true);
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
            Edition edition = editions.get(i);
            if (edition.isAvailable())
                System.out.println(editions.get(i));
        }
    }

    public void showEditions(int year) {
        for (int i = 0; i < editions.size(); i++) {
            Edition edition = editions.get(i);
            if (edition.getYear() == year)
                System.out.println(editions.get(i));
        }
    }

    public void showEditions(String name) {
        sortEditions();
        for (int i = 0; i < editions.size(); i++) {
            Edition edition = editions.get(i);
            if (edition.getName().contains(name))
                System.out.println(editions.get(i));
        }
    }

    public void showEditionsAtReaders() {
        sortReaders();
        for (int i = 0; i < readers.size(); i++) {
            System.out.println(readers.get(i));
            Reader currentReader = readers.get(i);
            currentReader.showEditions();
        }
    }

    public void showEditionsAtReaders(Reader reader) {
        System.out.println(reader);
        reader.showEditions();
    }

    public void sortReaders() {
        sortReadersByComparator(new NameReadersComparator<Reader>());
        sortReadersByComparator(new SurnameComparator<Reader>());
    }

    public void sortReadersByComparator(Comparator<Reader> comparator) {
        Reader temp;
        for (int i = readers.size() - 1; i > 0; i--)
            for (int j = 0; j < i; j++)
                if ((comparator.compare(readers.get(j), readers.get(j + 1)) > 0)) {
                    temp = readers.get(j + 1);
                    readers.set(j + 1, readers.get(j));
                    readers.set(j, temp);
                }
    }

    public void sortEditions() {
        sortEditionsByComparator(new NameEditionsComparator<Edition>());
        sortEditionsByComparator(new AuthorComparator<Edition>());
        sortEditionsByComparator(new TypeEditionsComparator<Edition>());
    }

    public void sortEditionsByComparator(Comparator<Edition> comparator) {
        Edition temp;
        for (int i = editions.size() - 1; i > 0; i--)
            for (int j = 0; j < i; j++)
                if ((comparator.compare(editions.get(j), editions.get(j + 1)) > 0)) {
                    temp = editions.get(j + 1);
                    editions.set(j + 1, editions.get(j));
                    editions.set(j, temp);
                }

    }


}
