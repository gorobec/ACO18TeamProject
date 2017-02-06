package week3.day2.generics.product;

import java.io.Serializable;

/**
 * Created by serhiim on 05-Feb-17.
 */
public class Product implements Comparable<Product>, Serializable {
    @Override
    public int compareTo(Product o) {
        return 0;
    }
}
