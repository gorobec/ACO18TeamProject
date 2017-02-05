package week3.day1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gorobec on 04.02.17.
 */
public class _01RawType {
    public static void main(String[] args) {
        List rawList = new ArrayList();
        List<String> genericList = new ArrayList<>();

        rawList.add(12);
        rawList.add("12");
        rawList.add('A');


        count(rawList);
       /* genericList.add(12);
        genericList.add("12");
        genericList.add('A');*/


    }

    public static void print(List list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
    public static void count(List list){
        int counter = 0;
        for (int i = 0; i < list.size(); i++) {
            counter += (Integer) list.get(i);
        }
        System.out.println(counter);
    }


}
