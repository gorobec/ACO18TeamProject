package recursion;

/**
 * Created by zhenia on 17.02.17.
 */
public class BunnyEars2 {
    public static int bunnyEars2(int bunnies){
        if(bunnies <= 0) return 0;

        return 2 + ((bunnies + 1) % 2) + bunnyEars2(bunnies - 1);
    }
}
