package library.comparators;

import library.model.PrintedEditions;

import java.util.Comparator;

/**
 * Created by User on 31.01.2017.
 */
public class PrintedEditionComparatorByPublishYear implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        PrintedEditions edition1 = (PrintedEditions) o1;
        PrintedEditions edition2 = (PrintedEditions) o2;
        if (edition1.getPublicationYear() > edition2.getPublicationYear())
            return 1;
        else if (edition1.getPublicationYear() < edition2.getPublicationYear())
            return -1;
        else
            return 0;
    }
}
