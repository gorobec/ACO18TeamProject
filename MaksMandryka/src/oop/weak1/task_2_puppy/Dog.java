package oop.weak1.task_2_puppy;

/**
 * Created by fmandryka on 24.01.2017.
 */
public class Dog extends Animal {

    private String breed;

    public Dog(String name, float age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    public void bite() {
        System.out.printf("The %s %s is biting!\n", breed, super.getName());
    }

    public void jump() {
        System.out.printf("The %s %s is jumping!\n", breed, super.getName());
    }

    public void run() {
        System.out.printf("The %s %s is running!\n", breed, super.getName());
    }

    public void makeSound() {
        System.out.println("Woof! Woof! Woof!");
    }
}
