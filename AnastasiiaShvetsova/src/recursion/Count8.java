package recursion;

/**
 * Created by Nastia on 15.02.17.
 */
public class Count8 {
    public int count8(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 8) {
            return 1;
        }

        int res = 0;

        if (n % 10 == 8) {
            res = 1;
        }
        if (n % 10 == 8 && n / 10 % 10 == 8) {
            res = 2;
        }

        return count8(n / 10) + res;
    }
}
