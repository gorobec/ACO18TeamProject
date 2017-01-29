package week2;

/**
 * Created by Валерий on 28.01.2017.
 */
public class StringVsStringBuilder {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 100_000; i++) {
            s += i + ", ";
        }
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);


        /*long start1 = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10_000_000; i++) {
            sb.append(i).append(", ");
        }
        String result = sb.toString();
        long finish1 = System.currentTimeMillis();
        System.out.println(finish1 - start1);*/
    }
}
