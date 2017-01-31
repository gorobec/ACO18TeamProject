package library;

public class Library {
    private Publication[] books;
    private int index = 0;
    private Readers readers;

    public Library(Readers readers) {
        this.readers = readers;
        books = new Publication[10];
    }

    public void addBook(Publication book) {
        books[index++] = book;
    }

    public void printAllBooks() {
        for (int i = 0; i < books.length && books[i] != null; i++) {
            books[i].printFullInfo();
        }
    }

    public boolean giveAbook(int bookID, int readerID) {
        if (bookID < books.length && readerID < readers.getTotalReaders()) {
            readers.takeBook(readerID);
            return books[bookID - 1].give(readerID);
        }
        return false;
    }
}