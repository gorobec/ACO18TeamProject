package week2.day1;

/**
 * Created by gorobec on 28.01.17.
 */
public class StringVsBuilder {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        String s = "";

        for (int i = 0; i < 1_000_000; i++) {
            s += i + ", ";
        }
//        System.out.println(s);
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);

        /*long start2 = System.currentTimeMillis();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10_000_000; i++) {
            sb.append(i).append(", ");
        }
//        System.out.println(s);
        String result = sb.toString();
        long finish2 = System.currentTimeMillis();
        System.out.println(finish2 - start2);*/
    }
}
