
package week4.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ksyashka on 16.02.2017.
 */
public class MergeSort<T extends Comparable<T>> implements Sort<T> {
    @Override
    public List<T> mySort(List<T> list) {
        return mergeSort(list);
    }

    private static <T extends Comparable<T>> List<T> mergeSort(List<T> list) {
        if (list.size() <= 1) return list;
        List<T> firstHalf = list.subList(0, list.size() / 2);
        List<T> secondHalf = list.subList(list.size() / 2, list.size());
        firstHalf = mergeSort(firstHalf);
        secondHalf = mergeSort(secondHalf);
        List<T> result = new ArrayList<>();
        merge(firstHalf, secondHalf, result);
        return result;

    }

    private static <T extends Comparable<T>> void merge(List<T> first, List<T> second, List<T> result) {
        int iFirst = 0;
        int iSecond = 0;
        while (iFirst <= first.size() && iSecond <= second.size()) {
            if (iFirst == first.size() && iSecond == second.size()) break;
            if (iFirst == first.size()) result.add(second.get(iSecond++));
            else {
                if (iSecond == second.size()) result.add(first.get(iFirst++));
                else {
                    if (first.get(iFirst).compareTo(second.get(iSecond)) < 0)
                        result.add(first.get(iFirst++));
                    else result.add(second.get(iSecond++));
                }
            }
        }

    }
}