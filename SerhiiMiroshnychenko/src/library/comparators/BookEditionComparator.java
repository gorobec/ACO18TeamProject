package library.comparators;

import library.model.Book;

import java.util.Comparator;

/**
 * Created by serhiim on 06-Feb-17.
 */
public class BookEditionComparator implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        Book book1 = (Book) o1;
        Book book2 = (Book) o2;

        return book1.getEditionName().compareTo(book2.getEditionName());
    }
}
