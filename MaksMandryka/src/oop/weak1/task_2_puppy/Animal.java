package oop.weak1.task_2_puppy;

/**
 * Created by fmandryka on 24.01.2017.
 */
public class Animal {

    private String name;
    private float age;

    public Animal(String name, float age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(float age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public float getAge() {
        return age;
    }

    public void showName() {
        System.out.printf("Animal name %s\n", name);
    }
}
