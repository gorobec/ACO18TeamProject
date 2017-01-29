package task2;

/**
 * Created by Sherlock on 27.01.2017.
 */
public class Run {
    public static void main(String[] args) {
        Puppy puppy = new Puppy("Rex", 3);

        puppy.printNameAge();
        puppy.jump();
        puppy.bite();
        puppy.run();
        puppy.voice();
    }
}
