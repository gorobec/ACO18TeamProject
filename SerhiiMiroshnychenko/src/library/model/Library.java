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

    public int findReader(Reader reader){
        for (int i = 0; i < readers.size(); i++) {
            if (readers.get(i).equals(reader)){
                return i;
            }
        }
        return -1;
    }

    public int findBook(PrintedEdition book){
        for (int i = 0; i < printedEditions.size(); i++) {
            if (printedEditions.get(i).equals(book)){
                return i;
            }
        }
        return -1;
    }

    public boolean giveBook(Reader reader, PrintedEdition book){
        Book temp = (Book) book;
        int readerIndex = findReader(reader);
        int bookIndex = findBook(book);
        int itemsInHands = readers.get(readerIndex).getCurrentItemsInHands();
        if (readerIndex == -1) return false;
        if (bookIndex == -1) return false;
        readers.get(readerIndex).getTakenBooks().add(temp);
        itemsInHands++;
        readers.get(readerIndex).setCurrentItemsInHands(itemsInHands);
        return true;
    }

}
