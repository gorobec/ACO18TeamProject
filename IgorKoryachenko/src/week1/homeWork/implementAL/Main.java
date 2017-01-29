package week1.homeWork.implementAL;

import java.util.ArrayList;

/**
 * Created by Игорь on 25.01.2017.
 */
public class Main {

    public static void main(String[] args) {


        ArrList list = new ArrList();
        list.add("1111");
        list.add("2222");
        list.add("3333");
        list.add("4444");
        list.add("5555");
        list.add("6666");
        list.add(3, "7777");
        list.add(5,"8888");
        list.remove(2);
        list.remove("5555");
        list.set(1, "2211");


        list.printString();
        System.out.println("Size of list - " + list.size());
        if (list.contains("656565")) System.out.println("contains");
        else System.out.println("not contains");
        System.out.println(list.get(1));

        list.clear();
        list.printString();
    }
}
