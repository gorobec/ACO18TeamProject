package oop.weak1.task_2_puppy;

/**
 * Created by fmandryka on 24.01.2017.
 */
public class Run {
    public static void main(String[] args) {

        Puppy puppy = new Puppy("Jack", 0.5f, "Husky");

        puppy.showName();

        puppy.bite();
        puppy.run();
        puppy.jump();
        puppy.makeSound();

    }
}
