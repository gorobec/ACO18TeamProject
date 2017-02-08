package library;

public class Library {
    private Publication[] books;
    private int index = 0;
    private Readers readers;

    public Library(Readers readers) {
        this.readers = readers;
        books = new Publication[10];
    }

    public int addBook(Publication book) {//3) добавить печатное издание в библиотеку
        books[index++] = book;
        return index;
    }

    public void printAllBooks() {
        for (int i = 0; i < books.length && books[i] != null; i++) {
            books[i].printFullInfo();
        }
    }

    public boolean giveAbook(int bookID, int readerID) {//5) выдать печатное издание читателю (если книга есть в наличии).
        if (bookID < books.length && readerID < readers.getTotalReaders()) {
            readers.takeBook(readerID);
            return books[bookID - 1].give(readerID);
        }
        return false;
    }

    public void printBooksOnHands() {//6) посмотреть список печатных изданий, которые находятся у читателей
        boolean printHandler = true;
        for (int i = 0; books[i] != null; i++) {
            if (books[i].onHands()) {
                if (printHandler) {
                    System.out.println("the following books are on readers hands:");
                    printHandler = false;
                }
                books[i].printFullInfo();
            }
        }
    }

    public void printAvailableBooks() {//2) посмотреть список доступных конкретных печатных изданий
        boolean printHandler = true;
        for (int i = 0; books[i] != null; i++) {
            if (!books[i].onHands()) {
                if (printHandler) {
                    System.out.println("the following books are available:");
                    printHandler = false;
                }
                books[i].printFullInfo();
            }
        }
    }

    public void printBooksOnHands(int readerID) {
        boolean printHandler = true;
        for (int i = 0; books[i] != null; i++) {
            if (books[i].getReaderID() == readerID) {
                if (printHandler) {
                    System.out.println("the following books are read by reader id " + readerID);
                    printHandler = false;
                }
                books[i].printFullInfo();
            }
        }
        if (printHandler) {
            System.out.println("the reader id " + readerID + " does not read any book");
        }
    }

    public void printBooksByAuthor(String author) {
        boolean printHandler = true;
        for (int i = 0; books[i] != null; i++) {
            if(books[i].getAuthor().compareTo(author)==0){
                if(printHandler){
                    System.out.println("there are following books written by " + author);
                    printHandler=false;
                }
                books[i].printFullInfo();
            }
        }
        if(printHandler){
            System.out.println("there is no any book written by "+author);
        }
    }

    public void printBooksByPatternAuthor(String authorPattern) {
        boolean printHandler = true;
        for (int i = 0; books[i] != null; i++) {
            if(books[i].getAuthor().contains(authorPattern)){
                if(printHandler){
                    System.out.println("there are following books contains " + authorPattern);
                    printHandler=false;
                }
                books[i].printFullInfo();
            }
        }
        if(printHandler){
            System.out.println("there is no any book containing "+authorPattern);
        }
    }
}