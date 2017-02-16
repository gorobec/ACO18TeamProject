package library.comparators;

import library.model.Book;
import library.model.PrintedEdition;

import java.util.Comparator;

/**
 * Created by serhiim on 06-Feb-17.
 */
public class BookAuthorComparator<T extends Book> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getAuthor().compareTo(o2.getAuthor());
    }
}
