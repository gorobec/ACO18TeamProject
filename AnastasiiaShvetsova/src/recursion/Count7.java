package recursion;

/**
 * Created by anastasiia.shvetsova on 2/15/2017.
 */
public class Count7 {
    public  int res = 0;

    public int count7(int n) {
        if(n == 7){
            return 1;
        }
        if(n == 0){
            return 0;
        }

        if(n%10 == 7) {
            res = 1 + count7(n/10);
        }
        else {
            res = count7(n/10);
        }
        return res;
    }

    public void showRes(){
        System.out.println(res);
    }
}
