package ACO.week2.homework.library.model;

import ACO.week2.homework.library.model.printed_editions.PrintedEdition;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by v21k on 31.01.17.
 */
public class Reader {
    private final int MAX_PRINTED_EDITIONS_PER_READER = 3;
    private String name;
    private List<PrintedEdition> printedEditions = new ArrayList<>();
    private int currentPrintedEditionsNumber = 0;
    private boolean inBlackList;

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

    public void setName(String name) {
        this.name = name;
    }

    public List<PrintedEdition> getPrintedEditions() {
        return printedEditions;
    }

    public void setPrintedEditions(List<PrintedEdition> printedEditions) {
        this.printedEditions = printedEditions;
    }

    public boolean isInBlackList() {
        return inBlackList;
    }

    public void setInBlackList(boolean inBlackList) {
        this.inBlackList = inBlackList;
    }

    public int getCurrentPrintedEditionsNumber() {
        return currentPrintedEditionsNumber;
    }

    public void setCurrentPrintedEditionsNumber(int currentPrintedEditionsNumber) {
        this.currentPrintedEditionsNumber = currentPrintedEditionsNumber;
    }

    public boolean addPrintedEdition(PrintedEdition printedEdition) {
        if (currentPrintedEditionsNumber < MAX_PRINTED_EDITIONS_PER_READER) {
            currentPrintedEditionsNumber++;
            return printedEditions.add(printedEdition);
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("Name - %s, current number of printed editions - %d",
                name, currentPrintedEditionsNumber);
    }
}
