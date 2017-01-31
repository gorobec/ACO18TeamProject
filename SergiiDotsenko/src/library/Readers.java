package library;

public class Readers {
    private Array_List<Reader> readers;

    public Readers() {
        readers = new Array_List<>();
    }

    public boolean addReader() {
        return readers.add(new Reader());
    }

    public void printAllReaders() {//1) посмотреть список читателей
        for (int i = 0; i < readers.size(); i++) {
            readers.get(i).printFullInfo();
        }
    }
    public int getTotalReaders(){
        return readers.size();
    }
    public boolean canTake(int readerID){
        return readers.get(readerID-1).canTakeBook();
    }
    public Reader get(int index){
        return readers.get(index);
    }

    public void takeBook(int readerID) {
        readers.get(readerID-1).takeBook();
    }
}