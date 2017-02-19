package week3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nastia on 05.02.17.
 */
public class Rozetka<T extends Product> {
    private List<T> items = new ArrayList<T>();

//    public static  boolean find(List<? extends Product> list, Product product){
//        for (Product product1 : list) {
//            if(product1.equals(product)) return true;
//        }
//        return false;
//    }
    public static <E extends Product> boolean find(List<E> list, E product){
        for (E product1 : list) {
            if(product1.equals(product)) return true;
        }
        return false;
    }

    public static <E> void copy(List<? extends E> src, List<? super E> dest){
        for(E o: src){
            dest.add(o);
        }
    }
}
