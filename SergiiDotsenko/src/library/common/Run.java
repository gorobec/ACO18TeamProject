package library.common;


import library.common.publication.Directory;
import library.common.publication.Encyclopedia;

public class Run {
    public static void main(String[] args) {
        Readers readers = new Readers();
        readers.addReader();
        readers.addReader();
        readers.addReader();
        readers.printAllReaders();


        Library library = new Library();
        library.addBook(new Encyclopedia("a1",1999));
        library.addBook(new Directory("a2",2222));
        library.printAllBooks();


    }
}