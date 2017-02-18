package week4.sort;

import java.util.List;

/**
 * Created by ksyashka on 17.02.2017.
 */
public interface Sort<T extends Comparable<T>> {
    List<T> mySort(List<T> list);
}
