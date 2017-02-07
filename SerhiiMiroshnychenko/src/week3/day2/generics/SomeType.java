package week3.day2.generics;

import java.util.Collection;
import java.util.List;

/**
 * Created by serhiim on 05-Feb-17.
 */
public class SomeType<T> {
    public <E> void print(Collection<E> collection){
        for (E e : collection){
            System.out.println(e);
        }
    }

    public void print(List<Integer> collection){
        for (Integer i : collection){
            System.out.println(i);
        }
    }

}
