package library.common;

public class Readers {
    private MyArrayList<Reader> readers;

    public Readers() {
        readers = new MyArrayList<>();
    }

    public boolean addReader() {
        return readers.add(new Reader());
    }

    public void printAllReaders() {
        for (int i = 0; i < readers.size(); i++) {
            readers.get(i).printFullInfo();
        }
    }
}