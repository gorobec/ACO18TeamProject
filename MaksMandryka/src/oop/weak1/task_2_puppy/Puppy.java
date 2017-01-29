package oop.weak1.task_2_puppy;

/**
 * Created by fmandryka on 24.01.2017.
 */
public class Puppy extends Dog {

    public Puppy(String name, float age, String breed) {
        super(name, age, breed);
    }

    public void makeSound() {
        System.out.println("Bowwow!");
    }
}
