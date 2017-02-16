package oop.week4.human;

import java.util.Arrays;
import java.util.List;

/**
 * Created by fmandryka on 12.02.2017.
 */
public class Human {

    private final String city;
    private final String name;
    private final int age;

    private final List<Pet> pets;

    public Human(String city, String name, int age, List<Pet> pets) {
        this.city = city;
        this.name = name;
        this.age = age;
        this.pets = pets;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Pet> getPets() {
        return pets;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append(city).append(", ").append(name).append(", ").append(age).append(", ").append(Arrays.toString(pets.toArray())).toString();
    }
}
