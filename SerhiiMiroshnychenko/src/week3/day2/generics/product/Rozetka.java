package week3.day2.generics.product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by serhiim on 05-Feb-17.
 */
public class Rozetka<T extends Product & Serializable> {
    private List<T> items = new ArrayList<>();

/*    public static boolean find(List<? extends Product> list, Product product) { *//*<? extends Product> method will accept all (?) that extends product*//*
        for (Product product1 : list) {
            if (product1.equals(product)) return true;
        }
        return false;
    }*/

    public static <E extends Product> boolean find(List<E> list, E product) {
        /*static <E> boolean declare generic for same products (can't find PC in Phones), can accept only Products*/
        for (E product1 : list) {
            if (product1.equals(product)) return true;
        }
        return false;
    }

    public static<E> void copy(List<? extends E> src, List<? super E> dest){
        for (E o : src) {
            dest.add(o);
        }
    }
}
