package base.weak2.codingBatStringTests;

import java.util.HashMap;
import java.util.Map;

import static base.weak2.StringUtils.*;

/**
 * Created by Администратор on 20.12.2016.

 Return a version of the given string, where for every star (*) in the string the star and the chars immediately to its left and right are gone. So "ab*cd" yields "ad" and "ab**cd" also yields "ad".

 starOut("ab*cd") → "ad"
 starOut("ab**cd") → "ad"
 starOut("sm*eilly") → "silly"
 */
public class StringUtilsStarOutTest {

    public static void main(String[] args) {

        HashMap<String, String> hmap = new HashMap<String, String>();

        hmap.put("ab*cd", "ad");
        hmap.put("ab**cd", "ad");
        hmap.put("sm*eilly", "silly");
        hmap.put("sm*eil*ly", "siy");
        hmap.put("sm***eil*ly", "siy");
        hmap.put("stringy*", "string");
        hmap.put("*stringy", "tringy");
        hmap.put("*str*in*gy", "ty");
        hmap.put("abc", "abc");
        hmap.put("a*bc", "c");
        hmap.put("ab", "ab");
        hmap.put("a*b", "");
        hmap.put("a", "a");
        hmap.put("a*", "");
        hmap.put("*a", "");
        hmap.put("*", "");
        hmap.put("", "");

        for (Map.Entry<String, String> entry : hmap.entrySet()) {

            System.out.println("String = " + entry.getKey());
            System.out.println("Expected = " + entry.getValue());
            System.out.println(starOut(entry.getKey()).equals(entry.getValue()));

        }

    }
}
