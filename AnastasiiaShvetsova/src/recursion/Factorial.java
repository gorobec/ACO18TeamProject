package recursion;

/**
 * Created by anastasiia.shvetsova on 2/15/2017.
 */
public class Factorial {

    public int factorial(int n) {
        if (n == 0) {
            return 1;
        }

        return n * factorial(n - 1);
    }

}
