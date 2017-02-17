package recursion;

/**
 * Created by zhenia on 17.02.17.
 */
public class DigitsSum {
    public static int digitsSum(int n){
        if(n <= 0) return 0;

        return (n % 10) + digitsSum(n / 10);
    }
}
