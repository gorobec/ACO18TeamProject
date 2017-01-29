package ACO.week1.puppy;

/**
 * Created by v21k on 24.01.17.
 */
public class Run {
    public static void main(String[] args) {
        Puppy puppy = new Puppy("Jack");
        Dog dog = new Dog("John");

        System.out.println(puppy.toString());
        puppy.jump(2);
        puppy.run(25);
        puppy.bark();
        puppy.bit();

        System.out.println();

        System.out.println(dog.toString());
        dog.jump(2);
        dog.run(25);
        dog.bark();
        dog.bit();
    }
}
