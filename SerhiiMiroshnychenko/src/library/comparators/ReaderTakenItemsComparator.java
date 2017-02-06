package library.comparators;

import library.model.Reader;

import java.util.Comparator;

/**
 * Created by serhiim on 06-Feb-17.
 */
public class ReaderTakenItemsComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Reader reader1 = (Reader) o1;
        Reader reader2 = (Reader) o2;

        return reader1.getTakenItems().size() - reader2.getTakenItems().size();

    }
}
