package week3.generics;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by gorobec on 05.02.17.
 */
public class TestSomeType {
    public static void main(String[] args) {
        SomeType<?> someType = new SomeType();

        List<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        someType.print(list);
    }
}
