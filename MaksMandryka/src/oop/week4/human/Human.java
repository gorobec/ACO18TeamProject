package oop.week4.human;

import java.util.List;

/**
 * Created by fmandryka on 12.02.2017.
 */
public class Human {

    String city;
    String name;
    int age;

    List<Pet> pets;

    public Human(String city, String name, int age, List<Pet> pets) {
        this.city = city;
        this.name = name;
        this.age = age;
        this.pets = pets;
    }
}
