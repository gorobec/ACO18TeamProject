package recursion;

/**
 * Created by anastasiia.shvetsova on 2/15/2017.
 */
public class BunnyEars2 {
    public int bunnyEars2(int bunnies) {
        if(bunnies == 0){
            return 0;
        }
        int res;
        if(bunnies%2 == 0){
            res = 3;
        } else {
            res = 2;
        }
        return res + bunnyEars2(bunnies - 1);
    }
}
