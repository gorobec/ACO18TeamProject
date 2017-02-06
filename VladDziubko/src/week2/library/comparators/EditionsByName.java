package week2.library.comparators;

import week2.library.editions.PrintEdition;

import java.util.Comparator;

public class EditionsByName implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        PrintEdition ed1 = (PrintEdition) o1;
        PrintEdition ed2 = (PrintEdition) o1;
        return ed1.getName().compareTo(ed2.getName());
    }
}
