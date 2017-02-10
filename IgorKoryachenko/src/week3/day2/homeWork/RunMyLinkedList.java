package week3.day2.homeWork;

import java.util.Iterator;

/**
 * Created by Мастер on 07.02.2017.
 */
public class RunMyLinkedList {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
       // MyLinkedList.Iter iter = new MyLinkedList.Iter();
        Iterator iterator = list.iterator();
        list.add("111");
        list.add("222");
        list.add("333");
        list.add(2, "555");

        System.out.println(list.get(2));

        /*while (iterator.hasNext()){
            System.out.println(iterator.next());
        }*/
    }
}
