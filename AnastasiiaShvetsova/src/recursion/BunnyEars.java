package recursion;

/**
 * Created by anastasiia.shvetsova on 2/15/2017.
 */
public class BunnyEars {
    public int bunnyEars(int bunnies) {
        if (bunnies == 0) {
            return 0;
        }
        int res = 2;
        return res + bunnyEars(bunnies - 1);
    }
}
