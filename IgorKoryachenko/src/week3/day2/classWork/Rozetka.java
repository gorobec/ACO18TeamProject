package week3.day2.classWork;

import java.util.ArrayList;
import java.util.List;

public class Rozetka<T extends Product> {
    private List<T> items = new ArrayList<>();

    public static <E> void copy(List<? extends E> src, List<? super E> dest){

        for (E o:  src) {
            dest.add(o);
        }
    }




}
