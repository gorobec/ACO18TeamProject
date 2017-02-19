package data_structures;

import java.util.Iterator;

/**
 * Created by ksyashka on 07.02.2017.

 package design_patterns.iterator;

 import data_structures.MyArrayList;
 import data_structures.MyList;

 import java.util.Iterator;

 /**
 * Created by gorobec on 05.02.17.
 */
public class Test {
    public static void main(String[] args) {
        MyList<String> list = new MyLinkedList<>();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        Iterator<String> iterator = list.iterator();
        Iterator<String> iterator2 = list.iterator();
        /*System.out.println("Iterator 1" + iterator.next());
        System.out.println("Iterator 1" + iterator.next());
        System.out.println("Iterator 1" + iterator.next());
        System.out.println("Iterator 2" + iterator2.next());
        System.out.println("Iterator 1" + iterator.next());
        System.out.println("remove D");
        System.out.println("Iterator 2" + iterator2.next());
        System.out.println("Iterator 2" + iterator2.next());
        System.out.println("Iterator 2" + iterator2.next());
*/

       while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        for (String s : list) {
            System.out.println(s);
        }
    }
}
