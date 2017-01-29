package week1.homeWork.klassMaterial.auto;

/**
 * Created by Игорь on 23.01.2017.
 */
public class RunAuto {
    public static void main(String[] args) {

        Wheel wheel =  new Wheel(14, true);
        Engine engine = new Engine(1500, false);
        Auto auto = new Auto("Honda", wheel, engine);
        auto.carRun();
        wheel.setWinter(wheel.changeSummerWeel(true));
        auto.setWheel(wheel);
        System.out.println();
        System.out.println();
        System.out.println("Mark of car - " + auto.getMark());

    }
}
