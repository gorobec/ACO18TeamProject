package library;

public class Reader {
    private int readerID;
    private static int totalReaders = 0;
    private final static int maxBooksOnHands = 3;
    private int booksOnHands = 0;
    private boolean blackList = false;

    public Reader() {
        readerID = ++totalReaders;
    }

    public int getReaderID() {
        return readerID;
    }

    public int getBooksOnHands() {
        return booksOnHands;
    }

    public void returnBook() {
        booksOnHands -= 1;
    }

    public void printFullInfo() {
        System.out.println(String.format("reader id is %d, books on hands are %d", readerID, booksOnHands));
    }
    public boolean canTakeBook(){
        return maxBooksOnHands > booksOnHands;
    }
    public boolean takeBook(){
        if(canTakeBook()){
            booksOnHands+=1;
            return true;
        }
        return false;
    }
}
