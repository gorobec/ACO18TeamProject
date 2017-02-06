package library;

import java.util.ArrayList;
import java.util.Collections;

public class Readers {
    private ArrayList<Reader> readers;

    public Readers() {
        readers = new ArrayList<>();
    }

    public boolean addReader() {//4) добавить читателя в список читателей
        return readers.add(new Reader());
    }

    public void printAllReaders() {//1) посмотреть список читателей

        Collections.sort(readers, new ReaderIDComparator().reversed());

        for (int i = 0; i < readers.size(); i++) {
            readers.get(i).printFullInfo();
        }
    }

    public int getTotalReaders() {
        return readers.size();
    }

    public boolean canTake(int readerID) {
        return readers.get(readerID - 1).canTakeBook();
    }

    public Reader get(int index) {
        return readers.get(index);
    }

    public void takeBook(int readerID) {
        readers.get(readerID - 1).takeBook();
    }
}