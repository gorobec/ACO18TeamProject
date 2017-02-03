package ACO.week2.homework.library.model;

import java.util.ArrayList;
import java.util.List;
import ACO.week2.homework.library.model.printed_editions.*;


/**
 * Created by v21k on 31.01.17.
 */
public class Library {
    private String name;
    private String city;
    private List<Reader> readers = new ArrayList<>();
    private List<PrintedEdition> printedEditionsInLibrary = new ArrayList<>();

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

    public List<Reader> getReaders() {
        return readers;
    }

    public void setReaders(List<Reader> readers) {
        this.readers = readers;
    }

    public List<PrintedEdition> getPrintedEditionsInLibrary() {
        return printedEditionsInLibrary;
    }

    public void setPrintedEditionsInLibrary(List<PrintedEdition> printedEditionsInLibrary) {
        this.printedEditionsInLibrary = printedEditionsInLibrary;
    }

    public boolean addReader(Reader reader) {
        if (reader != null) {
            return readers.add(reader);
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
