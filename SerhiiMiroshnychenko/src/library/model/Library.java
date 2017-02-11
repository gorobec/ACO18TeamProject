package library.model;

import library.comparators.BookAuthorComparator;
import library.comparators.ReaderFirstNameComparator;

import java.util.*;

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

    public boolean addReaderToBlackList(Reader reader) {
        int readerIndex = findReader(reader);
        if (readerIndex == -1) return false;
        readers.get(readerIndex).setInBlackList(true);
        return true;
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
        if (readerIndex == -1 || bookIndex == -1 || readers.get(readerIndex).getInBlackList() || bookCopies == 0)
            return false;
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

    public String getAllTakenItems() {
        StringBuilder builder = new StringBuilder();
        for (Reader aReader : readers) {
            ArrayList<PrintedEdition> takenItems = aReader.getTakenItems();
            for (int i = 0; i < takenItems.size(); i++) {
                builder.append(takenItems.get(i).toString()).append("\n");
            }
        }
        return builder.toString();
    }

    public String getTakenItemsByReader(Reader reader) {
        int readerIndex = findReader(reader);
        if (readerIndex == -1) return "No items";
        return reader.getTakenItems().toString();
    }

    public String readersToString() {
        ArrayList<Reader> sorted = readers;
        Collections.sort(sorted, new ReaderFirstNameComparator());
        StringBuilder builder = new StringBuilder();
        for (Reader aReader : sorted) {
            builder.append(aReader).append("\n");
        }
        return builder.toString();
    }

    public String itemsToString() {
        ArrayList<PrintedEdition> sorted = printedEditions;
        Collections.sort(sorted, new BookAuthorComparator());
        StringBuilder builder = new StringBuilder();
        for (PrintedEdition item : sorted) {
            if (item.getCopiesCount() > 0) {
                builder.append(item.toString()).append("\n");
            }
        }
        return builder.toString();
    }

    public String getItemsByAuthor(String author) {
        if (author == null || !printedEditions.toString().contains(author)) return "Invalid author";
        StringBuilder builder = new StringBuilder();
        for (PrintedEdition item : printedEditions) {
            if (item.toString().contains(author)) {
                builder.append(item).append("\n");
            }
        }
        return builder.toString();
    }

    public String getItemsByDate(String date) {
        if (date == null || !printedEditions.toString().contains(date)) return "Invalid author";
        StringBuilder builder = new StringBuilder();
        for (PrintedEdition item : printedEditions) {
            if (item.toString().contains(date)) {
                builder.append(item).append("\n");
            }
        }
        return builder.toString();
    }

    public String getItemsByEdition(String edition) {
        if (edition == null || !printedEditions.toString().contains(edition)) return "Invalid author";
        StringBuilder builder = new StringBuilder();
        for (PrintedEdition item : printedEditions) {
            if (item.toString().contains(edition)) {
                builder.append(item).append("\n");
            }
        }
        return builder.toString();
    }

    public String findItemByName(String name) {
        for (PrintedEdition item : printedEditions) {
            if (name != null && name.equals(item.getName())){
                return item.toString();
            }
        }
        return "Invalid name";
    }
}