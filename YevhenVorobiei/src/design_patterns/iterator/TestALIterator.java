package design_patterns.iterator;

import data_structures.MyArrayList;
import data_structures.MyList;

import java.util.Iterator;

/**
 * Created by gorobec on 05.02.17.
 */
public class TestALIterator {
    public static void main(String[] args) {
        MyList<String> list = new MyArrayList<>();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        Iterator<String> iterator = list.iterator();
        Iterator<String> iterator2 = list.iterator();
        System.out.println("Iterator 1" + iterator.next());
        System.out.println("Iterator 1" + iterator.next());
        System.out.println("Iterator 1" + iterator.next());
        System.out.println("Iterator 2" + iterator2.next());
        System.out.println("Iterator 1" + iterator.next());
        System.out.println("remove D");
        list.remove(3);
        System.out.println("Iterator 2" + iterator2.next());
        System.out.println("Iterator 2" + iterator2.next());
        System.out.println("Iterator 2" + iterator2.next());


       /* while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        for (String s : list) {
            System.out.println(s);
        }*/
    }
}
