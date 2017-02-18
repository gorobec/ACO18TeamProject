package week4.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ksyashka on 17.02.2017.
 */
public class QuickSort<T extends Comparable<T>> implements Sort<T> {
    @Override
    public List<T> mySort(List<T> list) {
        quickSort(list);
        return list;
    }

    private static <T extends Comparable<T>> void quickSort(List<T> list) {
        int l = 0;
        int r = list.size() - 1;
        T value = list.get(l);
        T temp;

        while (l <= r) {
            while (list.get(l).compareTo(value) < 0) l++;
            while (list.get(r).compareTo(value) > 0) r--;
            if (l <= r) {
                temp = list.get(r);
                list.set(r, list.get(l));
                list.set(l, temp);
                l++;
                r--;
            }
        }

        if (r > 0) {
            quickSort(list.subList(0, r + 1));
        }

        if (l < list.size()) {
            quickSort(list.subList(l, list.size()));
        }
    }


}
