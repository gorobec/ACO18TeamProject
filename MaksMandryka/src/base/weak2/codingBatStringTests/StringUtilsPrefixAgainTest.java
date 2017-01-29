package base.weak2.codingBatStringTests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static base.weak2.StringUtils.*;

/**
 * Created by Администратор on 21.12.2016.
 Given a string, consider the prefix string made of the first N chars of the string. Does that prefix string appear somewhere else in the string? Assume that the string is not empty and that N is in the range 1..str.length().
 prefixAgain("abXYabc", 1) → true
 prefixAgain("abXYabc", 2) → true
 prefixAgain("abXYabc", 3) → false
 */
public class StringUtilsPrefixAgainTest {

    public static void main(String[] args) {

        List<String> ls1 = new ArrayList<String>();
        List<String> ls2 = new ArrayList<String>();
        List<String> ls3 = new ArrayList<String>();
        List<String> ls4 = new ArrayList<String>();
        List<String> ls5 = new ArrayList<String>();
        List<String> ls6 = new ArrayList<String>();
        List<String> ls7 = new ArrayList<String>();
        List<String> ls8 = new ArrayList<String>();
        List<String> ls9 = new ArrayList<String>();
        List<String> ls10 = new ArrayList<String>();
        List<String> ls11 = new ArrayList<String>();
        List<String> ls12 = new ArrayList<String>();
        ls1.add("abXYabc");
        ls1.add("1");
        ls2.add("abXYabc");
        ls2.add("2");
        ls3.add("abXYabc");
        ls3.add("3");
        ls4.add("xyzxyxyxy");
        ls4.add("2");
        ls5.add("xyzxyxyxy");
        ls5.add("3");
        ls6.add("Hi12345Hi6789Hi10");
        ls6.add("1");
        ls7.add("Hi12345Hi6789Hi10");
        ls7.add("2");
        ls8.add("Hi12345Hi6789Hi10");
        ls8.add("3");
        ls9.add("Hi12345Hi6789Hi10");
        ls9.add("4");
        ls10.add("a");
        ls10.add("1");
        ls11.add("aa");
        ls11.add("1");
        ls12.add("ab");
        ls12.add("1");

        HashMap<List<String>, Boolean> hmap = new HashMap<List<String>, Boolean>();

        hmap.put(ls1, true);
        hmap.put(ls2, true);
        hmap.put(ls3, false);
        hmap.put(ls4, true);
        hmap.put(ls5, false);
        hmap.put(ls6, true);
        hmap.put(ls7, true);
        hmap.put(ls8, true);
        hmap.put(ls9, false);
        hmap.put(ls10, false);
        hmap.put(ls11, true);
        hmap.put(ls12, false);


        for (Map.Entry<List<String>, Boolean> entry : hmap.entrySet()) {

            System.out.println("String = " + entry.getKey());
            System.out.println("Expected = " + entry.getValue());
            System.out.println(prefixAgain(entry.getKey().get(0), Integer.parseInt(entry.getKey().get(1))) == entry.getValue());

        }

    }

}
