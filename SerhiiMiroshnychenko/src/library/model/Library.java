package library.model;

import java.util.ArrayList;

/**
 * Created by serhiim on 31-Jan-17.
 */
public class Library {
    private ArrayList<PrintedEdition> printedEditions;
    private ArrayList<Reader> readers;

    public Library() {
    }

    public Library(ArrayList<PrintedEdition> printedEditions, ArrayList<Reader> readers) {
        this.printedEditions = printedEditions;
        this.readers = readers;
    }

    public int findReader(Reader reader) {
        for (int i = 0; i < readers.size(); i++) {
            if (readers.get(i).equals(reader)) {
                return i;
            }
        }
        return -1;
    }

    public int findItem(PrintedEdition item) {
        for (int i = 0; i < printedEditions.size(); i++) {
            if (printedEditions.get(i).equals(item)) {
                if (printedEditions.get(i).getCopiesCount() > 0)
                    return i;
            }
        }
        return -1;
    }

    public boolean giveItem(Reader reader, PrintedEdition item) {
        int readerIndex = findReader(reader);
        int bookIndex = findItem(item);
        int bookCopies = item.getCopiesCount();
        if (readerIndex == -1 || bookIndex == -1) return false;
        readers.get(readerIndex).takeItem(printedEditions.get(bookIndex));
        item.setCopiesCount(bookCopies - 1);
        return true;
    }

    public boolean takeItem(Reader reader, PrintedEdition book) {
        int copies = book.getCopiesCount();
        int readerIndex = findReader(reader);
        int bookIndex = findItem(book);
        readers.get(readerIndex).returnItem(book);
        printedEditions.get(bookIndex).setCopiesCount(copies + 1);
        return true;
    }

    public ArrayList<PrintedEdition> getPrintedEditions() {
        return printedEditions;
    }

    public ArrayList<Reader> getReaders() {
        return readers;
    }
}