package week3;

import java.util.Collection;
import java.util.List;

public class SomeType<T> {
    public <E> void print(Collection<E> collection) {
        for(E e: collection){
            System.out.println(e);
        }
    }

    public void print(List<Integer> collections){
        for (Integer i: collections){
            System.out.println(i);
        }
    }
}
