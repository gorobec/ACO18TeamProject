package ACO.week2.homework.library.comparators;

import ACO.week2.homework.library.model.printed_editions.PrintedEdition;

import java.util.Comparator;

/**
 * Created by v21k on 31.01.17.
 */
public class PEByYearComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        PrintedEdition r1 = (PrintedEdition) o1;
        PrintedEdition r2 = (PrintedEdition) o2;
        return r1.getYear() - r2.getYear();
    }
}
