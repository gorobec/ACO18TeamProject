package recursion;

/**
 * Created by anastasiia.shvetsova on 2/15/2017.
 */
public class TestRecursion {
    public static void main(String[] args) {
        Count7 count = new Count7();
        CountX count1 = new CountX();

        count.count7(717);
        count.showRes();
        count1.countX("hxxhy");
    }
}
