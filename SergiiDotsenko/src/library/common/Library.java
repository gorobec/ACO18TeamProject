package library.common;

import library.common.publication.Publication;

public class Library {
    private Publication[] books;
    private int index = 0;

    public Library() {
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
//    public void giveAbook()
}