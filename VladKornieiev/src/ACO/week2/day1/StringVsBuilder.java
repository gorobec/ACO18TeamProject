package ACO.week2.day1;

/**
 * Created by v21k on 28.01.17.
 */
public class StringVsBuilder {
    public static void main(String[] args) {

        // String
        long start = System.currentTimeMillis();

        String s = "";
        for (int i = 0; i < 100_000; i++) {
            s += i + ", ";
        }
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);


/*        // StringBuilder
        long start2 = System.currentTimeMillis();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10_000_000; i++) {
            sb.append(i).append(", ");
        }
        String result = sb.toString();
        long finish2 = System.currentTimeMillis();
        System.out.println(finish2 - start2);
    }*/
    }
}
