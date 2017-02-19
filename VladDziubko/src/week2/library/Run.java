package week2.library;


import week2.library.editions.PrintEdition;
import week2.library.readers.Reader;

public class Run {
    public static void main(String[] args) {
        Reader reader = new Reader("Gena", "Ivanov");
        Reader reader1 = new Reader("Seva", "Egorov");
        Reader reader2 = new Reader("Taras", "Potapenko");
        Reader reader3 = new Reader("Lola", "Rush");

        Library lib = new Library();
        lib.addReaderToLibrary(reader);
        lib.addReaderToLibrary(reader1);
        lib.addReaderToLibrary(reader2);
        lib.addReaderToLibrary(reader3);
        lib.readersList();

        System.out.println();

        PrintEdition edition = new PrintEdition("Java 8", "Schildt", "programming", 2015);
        PrintEdition edition1 = new PrintEdition("The Lord of the rings", "Tolkien",
                "fantasy", 1954);
        PrintEdition edition2 = new PrintEdition("C++: The Complete Reference", "Schildt",
                "programming", 2008);
        PrintEdition edition3 = new PrintEdition("Java 7", "Schildt", "programming", 2013);

        lib.addPrintEditionToLibrary(edition);
        lib.addPrintEditionToLibrary(edition1);
        lib.addPrintEditionToLibrary(edition2);
        lib.addPrintEditionToLibrary(edition3);

        reader.takePrintEdition(edition3);
        reader.takePrintEdition(edition);
        reader.showTakenBooks();

        //lib.showBooksByYear(2015);

        //lib.concreteEditionInLibrary("the lord of the rings");

    }

}
