package library;

public class Reader {
    private int readerID;
    private static int totalReaders = 0;
    private final static int MAX_BOOKS_ON_HANDS = 3;//Подумать какие константы можно добавить в вашу программу "Библиотека", при наличии таких - реализуйте вашу задумку.
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
        System.out.printf("reader id is %d, books on hands are %d\n", readerID, booksOnHands);
    }

    public boolean canTakeBook() {//Читателю запрещается брать больше 3-х печатных изданий(либо другого количества печатных изданий).
        return MAX_BOOKS_ON_HANDS > booksOnHands && !blackList;
    }

    public boolean takeBook() {//5) выдать печатное издание читателю (если книга есть в наличии).
        if (canTakeBook()) {
            booksOnHands += 1;
            return true;
        }
        return false;
    }

    public void addReaderIntoBlackList() {//8) добавить читателя в черный список (ему нельзя выдавать печатные издания)
        blackList = true;
    }
}
