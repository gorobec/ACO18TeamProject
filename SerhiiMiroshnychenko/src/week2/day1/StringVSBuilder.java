package week2.day1;

/**
 * Created by serhiim on 28-Jan-17.
 */
public class StringVSBuilder {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < 100000; i++) {
            str += i + ", ";

        }

        long finish = System.currentTimeMillis();
        System.out.println(finish - start);

        long start2 = System.currentTimeMillis();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            sb.append(i);
            sb.append(", ");
        }

        long finish2 = System.currentTimeMillis();
        System.out.println(finish2 - start2);
    }
}
