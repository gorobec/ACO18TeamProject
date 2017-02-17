package utils;

import customer.Customer;

import java.util.Comparator;

/**
 * Created by zhenia on 04.02.17.
 */
public class NameComparator implements Comparator <Comparable>{
    @Override
    public int compare(Comparable customer, Comparable t1) {
        return customer.compareTo(t1);
    }
}
