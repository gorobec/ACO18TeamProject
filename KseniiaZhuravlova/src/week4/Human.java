package week4;

import java.util.List;
import java.util.StringJoiner;

/**
 * Created by ksyashka on 12.02.2017.
 */
public class Human {
    private String name;
    private int age;
    private String city;
    private List<Pet> pets;

    public Human(String name, int age, String city, List<Pet> pets) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.pets = pets;
    }

    @Override
    public String toString() {
     return String.format("Name - %s, age - %d, city - %s \n Pets: %s", name, age, city, pets);

    }
}
