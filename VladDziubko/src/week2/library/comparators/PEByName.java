package week2.library.comparators;

import week2.library.editions.PrintEdition;

import java.util.Comparator;

public class PEByName implements Comparator<PrintEdition> {
    @Override
    public int compare(PrintEdition o1, PrintEdition o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
