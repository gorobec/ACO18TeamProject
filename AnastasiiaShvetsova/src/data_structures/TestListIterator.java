package data_structures;

import java.util.Iterator;

/**
 * Created by anastasiia.shvetsova on 2/9/2017.
 */
public class TestListIterator {
    public static void main(String[] args) {
        MyList<String> list = new MyLinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
