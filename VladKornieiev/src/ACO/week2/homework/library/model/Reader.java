package ACO.week2.homework.library.model;

import ACO.data_structures.MyArrayList;
import ACO.week2.homework.library.model.printed_editions.PrintedEdition;

/**
 * Created by v21k on 31.01.17.
 */
public class Reader {
    private String name;
    private MyArrayList printedEditions = new MyArrayList();
    private int currentPrintedEditionsNumber = 0;
    private int maxPrintedEditionsPerReader = 3;

    public Reader(String name, int currentPrintedEditionsNumber) {
        this.name = name;
        this.currentPrintedEditionsNumber = currentPrintedEditionsNumber;
    }

    public Reader(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCurrentPrintedEditionsNumber() {
        return currentPrintedEditionsNumber;
    }

    public void setCurrentPrintedEditionsNumber(int currentPrintedEditionsNumber) {
        this.currentPrintedEditionsNumber = currentPrintedEditionsNumber;
    }

    public MyArrayList getPrintedEditions() {
        return printedEditions;
    }

    public void setMaxPrintedEditionsPerReader(int maxPrintedEditionsPerReader) {
        this.maxPrintedEditionsPerReader = maxPrintedEditionsPerReader;
    }

    public boolean addPrintedEdition(PrintedEdition printedEdition) {
        if (currentPrintedEditionsNumber < maxPrintedEditionsPerReader) {
            currentPrintedEditionsNumber++;
            return printedEditions.add(printedEdition);
        }
        return false;
    }

    public void removePrintedEdition(PrintedEdition printedEdition) {
        printedEditions.remove(printedEdition);
    }

    @Override
    public String toString() {
        return String.format("Name - %s, current number of printed editions - %d",
                name, currentPrintedEditionsNumber);
    }
}
