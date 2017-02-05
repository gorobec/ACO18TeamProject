package week3.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gorobec on 04.02.17.
 */
public class _02RawWithGeneric {
    public static void main(String[] args) {
        List<Object> rawList = new ArrayList<>();
        List<Integer> genericList = new ArrayList<>();

//        rawList = genericList;

        rawList.add(12);
        rawList.add("12");
        rawList.add('A');

        int counter = 0;

        for (int i = 0; i < genericList.size(); i++) {
            counter += genericList.get(i);
        }
        System.out.println(counter);
    }

}
