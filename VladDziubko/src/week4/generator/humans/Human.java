package week4.generator.humans;

import week4.generator.pets.Pet;

import java.util.List;

public class Human {
    private String name;
    private int age;
    private List<Pet> pets;

    public Human(String name, int age, List<Pet> pets) {
        this.name = name;
        this.age = age;
        this.pets = pets;
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
}
