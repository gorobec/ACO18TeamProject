package recursion;

/**
 * Created by zhenia on 17.02.17.
 */
public class PowerN {
    public static int powerN(int base, int n){
        if(n == 1) return base;

        return base * powerN(base, n - 1);
    }
}
