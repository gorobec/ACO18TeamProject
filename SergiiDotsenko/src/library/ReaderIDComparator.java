package library;

import java.util.Comparator;

public class ReaderIDComparator implements Comparator<Reader> {
    @Override
    public int compare(Reader o1, Reader o2) {
        return Integer.compare(o1.getReaderID(), o2.getReaderID());
    }
}