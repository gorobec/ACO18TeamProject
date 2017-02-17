package recursion;

/**
 * Created by zhenia on 17.02.17.
 */
public class Factorial {
    public static int factorial(int num){
        if(num < 0) return 0;
        if (num == 0 || num == 1) return 1;

        return factorial(num-1) * num;
    }
}
