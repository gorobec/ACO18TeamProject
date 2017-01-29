package base.weak2.codingBatStringTests;

import java.util.HashMap;
import java.util.Map;

import static base.weak2.StringUtils.*;

/**
 * Created by Администратор on 21.12.2016.
 * <p>
 * We'll say that a String is xy-balanced if for all the 'x' chars in the string, there exists a 'y' char somewhere later in the string. So "xxy" is balanced, but "xyx" is not. One 'y' can balance multiple 'x's. Return true if the given string is xy-balanced.
 * <p>
 * xyBalance("aaxbby") → true
 * xyBalance("aaxbb") → false
 * xyBalance("yaaxbb") → false
 */
public class StringUtilsXyBalanceTest {

    public static void main(String[] args) {

        HashMap<String, Boolean> hmap = new HashMap<String, Boolean>();

        hmap.put("aaxbby", true);
        hmap.put("aaxbb", false);
        hmap.put("yaaxbb", false);
        hmap.put("yaaxbby", true);
        hmap.put("xaxxbby", true);
        hmap.put("xaxxbbyx", false);
        hmap.put("xxbxy", true);
        hmap.put("xxbx", false);
        hmap.put("bbb", true);
        hmap.put("bxbb", false);
        hmap.put("bxyb", true);
        hmap.put("xy", true);
        hmap.put("y", true);
        hmap.put("x", false);
        hmap.put("", true);
        hmap.put("yxyxyxyx", false);
        hmap.put("yxyxyxyxy", true);
        hmap.put("12xabxxydxyxyzz", true);

        for (Map.Entry<String, Boolean> entry : hmap.entrySet()) {

            System.out.println("String = " + entry.getKey());
            System.out.println("Expected = " + entry.getValue());
            System.out.println(xyBalance(entry.getKey()) == entry.getValue());

        }

    }

}
