package week3.day2.generics;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by serhiim on 05-Feb-17.
 */
public class TestSomeType {
    public static void main(String[] args) {
        //SomeType someType = new SomeType(); will crash with ClassCastException as someType created as not  generic
        SomeType<?> someType = new SomeType(); /* <?> means any type (make someType generic)*/
        List<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("B");

        someType.print(list);
    }
}
