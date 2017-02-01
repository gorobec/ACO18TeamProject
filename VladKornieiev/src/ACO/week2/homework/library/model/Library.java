package ACO.week2.homework.library.model;

import ACO.data_structures.MyArrayList;
import ACO.week2.homework.library.model.printed_editions.PrintedEdition;

/**
 * Created by v21k on 31.01.17.
 */
public class Library {
    private String name;
    private String city;
    private MyArrayList readers = new MyArrayList();
    private MyArrayList blackList = new MyArrayList();
    private MyArrayList printedEditionsInLibrary = new MyArrayList();

    public Library() {
        this.name = "Library";
        this.city = "Kyiv";
    }

    public Library(String name, String city, int maxPrintedEditionsPerStudent) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public MyArrayList getReaders() {
        return readers;
    }

    public MyArrayList getBlackList() {
        return blackList;
    }

    public MyArrayList getPrintedEditionsInLibrary() {
        return printedEditionsInLibrary;
    }

    public boolean addReader(Reader reader) {
        if (reader != null) {
            return readers.add(reader);
        }
        return false;
    }

    public boolean addReaderToBlackList(Reader reader) {
        if (!blackList.contains(reader) && readers.contains(reader) && reader != null) {
            blackList.add(reader);
            return true;
        }
        return false;
    }

    public boolean addPrintedEdition(PrintedEdition printedEdition) {
        if (!printedEditionsInLibrary.contains(printedEdition) && printedEdition != null) {
            printedEditionsInLibrary.add(printedEdition);
            return true;
        }
        return false;
    }

    public boolean removePrintedEdition(PrintedEdition printedEdition) {
        return printedEditionsInLibrary.remove(printedEdition);
    }

}
