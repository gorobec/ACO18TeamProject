package library.common;

public class Reader {
    private int readerID;
    private static int totalReaders = 0;
    private final int maxBooksOnHands = 3;
    private int booksOnHands = 0;

    public Reader() {
        readerID = ++totalReaders;
    }

    public int getReaderID() {
        return readerID;
    }

    public int getBooksOnHands() {
        return booksOnHands;
    }

    public void takeBook() {
        if (booksOnHands < maxBooksOnHands) {
            booksOnHands += 1;
        }
    }

    public void returnBook() {
        booksOnHands -= 1;
    }

    public void printFullInfo() {
        System.out.println(String.format("reader id is %d, books on hands are %d", readerID, booksOnHands));
    }
}
