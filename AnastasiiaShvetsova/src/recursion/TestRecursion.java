package recursion;

/**
 * Created by anastasiia.shvetsova on 2/15/2017.
 */
public class TestRecursion {
    public static void main(String[] args) {
        Count7 count = new Count7();
        CountX count1 = new CountX();
        CountHi count2 = new CountHi();
        Count8 count3 = new Count8();
        ChangePi str = new ChangePi();
        NoX str1 = new NoX();
        Triangle triangle = new Triangle();

        count.count7(717);
        count.showRes();
        count1.countX("hxxhy");
        str.changePi("pipi");
        str1.noX("adxvx");
        count2.countHi("xhixhix");
        count3.count8(8088);
        triangle.triangle(5);
    }
}
