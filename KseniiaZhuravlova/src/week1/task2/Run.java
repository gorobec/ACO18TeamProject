package week1.task2;

/**
 * Created by ksyashka on 23.01.2017.
 */
public class Run {
    public static void main(String arg[]) {
        Puppy puppy = new Puppy("Lassie", "Collie");

        puppy.showName();
        puppy.jump();
        puppy.bite();
        puppy.run();
        System.out.print(puppy.speak());
    }
}
