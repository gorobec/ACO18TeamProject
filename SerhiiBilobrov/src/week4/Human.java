package week4;

import java.util.List;

/**
 * @author Serhii Bilobrov
 * @since 1.7
 */
public class Human {
    private final String name;
    private final int age;
    private final String city;
    private final List<Pet> pets;

    public Human(String name, int age, String city, List<Pet> pets) {

        this.name = name;
        this.age = age;
        this.city = city;
        this.pets = pets;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public List<Pet> getPets() {
        return pets;
    }
}
