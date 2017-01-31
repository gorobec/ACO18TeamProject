package library;

public class RunLibrary {

    static Readers readers = new Readers();
    static Library library = new Library(readers);

    public static void main(String[] args) {
        testReaders();
        testLibrary();
        testGiveAbook();
        readers.printAllReaders();
    }

    private static void testReaders() {
        readers.addReader();
        readers.addReader();
        readers.addReader();
        readers.addReader();
        readers.printAllReaders();
    }

    private static void testLibrary() {
        library.addBook(new Encyclopedia("a1", 1999));
        library.addBook(new Directory("a2", 2222));
        library.printAllBooks();
    }

    private static boolean testGiveAbook(){
        return library.giveAbook(1,2) && library.giveAbook(2,2);
    }
}