package recursion;

/**
 * Created by zhenia on 17.02.17.
 */
public class BunnyEars {
    public static int countEars(int bunny){
        if(bunny <= 0) return 0;

        return 2 + countEars(bunny - 1);
    }
}
