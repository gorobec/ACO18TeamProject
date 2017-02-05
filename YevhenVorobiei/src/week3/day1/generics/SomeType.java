package week3.day1.generics;

import java.util.Collection;
import java.util.List;

/**
 * Created by gorobec on 05.02.17.
 */
public class SomeType<T> {

    public <E> void print(Collection<E> collection) {
        for (E e : collection) {
            System.out.println(e);
        }
    }

    public void print(List<Integer> collection) {
        for (Integer i : collection) {
            System.out.println(i);
        }
    }


}
