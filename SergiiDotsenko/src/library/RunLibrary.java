package library;

public class RunLibrary {

    static Readers readers = new Readers();
    static Library library = new Library(readers);

    public static void main(String[] args) {
        testReaders();
        testLibrary();
        testGiveAbook();
//        library.printBooksByAuthor("a1");
        library.printBooksByPatternAuthor("f");
//        readers.printAllReaders();
//        library.printBooksOnHands(2);
//        library.printBooksOnHands(1);
//        library.printAvailableBooks();
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
        library.addBook(new Directory("ff", 2222));
        library.printAllBooks();
    }

    private static boolean testGiveAbook(){
        return library.giveAbook(1,2) && library.giveAbook(2,2);
    }
}