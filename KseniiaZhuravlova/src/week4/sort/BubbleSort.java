package week4.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ksyashka on 17.02.2017.
 */
public class BubbleSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public List<T> mySort(List<T> list) {
        sortBubble(list);
        return list;
    }


    public static <T extends Comparable<T>> void sortBubble(List<T> list) {
        int len = list.size();
        T temp;
        for (int i = len - 1; i > 0; i--)
            for (int j = 0; j < i; j++)
                if (list.get(j).compareTo(list.get(j+1)) > 0) {
                    temp = list.get(j+1);
                    list.set(j + 1, list.get(j));
                    list.set(j , temp);
                }
    }


}
