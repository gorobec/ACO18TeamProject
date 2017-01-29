package base.weak2.codingBatStringTests;

import java.util.HashMap;
import java.util.Map;

import static base.weak2.StringUtils.*;

/**
 * Created by Администратор on 20.12.2016.
 * Return the number of times that the string "code" appears anywhere in the given string, except we'll accept any letter for the 'd', so "cope" and "cooe" count.
 * <p>
 * countCode("aaacodebbb") → 1
 * countCode("codexxcode") → 2
 * countCode("cozexxcope") → 2
 */
public class StringUtilsCountCodeTest {

    public static void main(String[] args) {

        HashMap<String, Integer> hmap = new HashMap<String, Integer>();

        hmap.put("aaacodebbb", 1);
        hmap.put("codexxcode", 2);
        hmap.put("cozexxcope", 2);
        hmap.put("cozfxxcope", 1);
        hmap.put("xxcozeyycop", 1);
        hmap.put("cozcop", 0);
        hmap.put("abcxyz", 0);
        hmap.put("code", 1);
        hmap.put("ode", 0);
        hmap.put("c", 0);
        hmap.put("", 0);
        hmap.put("AAcodeBBcoleCCccoreDD", 3);
        hmap.put("AAcodeBBcoleCCccorfDD", 2);
        hmap.put("coAcodeBcoleccoreDD", 3);

        for (Map.Entry<String, Integer> entry : hmap.entrySet()) {

            System.out.println("String = " + entry.getKey());
            System.out.println("Expected = " + entry.getValue());
            System.out.println(countCode(entry.getKey()) == entry.getValue());

        }

    }
}
