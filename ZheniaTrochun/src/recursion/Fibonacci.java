package recursion;

/**
 * Created by zhenia on 17.02.17.
 */
public class Fibonacci {
    public static int fibonacci(int num){
        if(num < 0) return 0;

        if(num == 0 || num == 1) return num;

        return fibonacci(num - 1) + fibonacci(num - 2);
    }
}
