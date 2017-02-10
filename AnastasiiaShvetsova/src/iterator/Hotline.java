package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Nastia on 09.02.17.
 */
public class Hotline {
    private List<Product> products = new ArrayList<>();
    public boolean addProducts (Iterator<Product> iterator){

        while (iterator.hasNext()){
            products.add(iterator.next());
        }
        return true;
    }
    public void showHotlineProducts(){
        System.out.println("Rozetka's products - " + products);
    }
}
