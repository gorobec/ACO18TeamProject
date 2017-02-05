package week3.day1.generics.product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gorobec on 05.02.17.
 */
public class Rozetka<T extends Product> {
    private List<T> items = new ArrayList<>();


   /* public static boolean find(List<? extends Product> list, Product product){
        for (Product product1 : list) {
            if(product.equals(product1)) return  true;
        }
        return false;
    }*/
    public static <E extends Product>  boolean find(List<E> list, E product){
        for (E product1 : list) {
            if(product.equals(product1)) return  true;
        }
        return false;
    }

    public static<E> void copy(List src, List dest){
        for (Object o : src) {
            dest.add(o);
        }
    }
}
