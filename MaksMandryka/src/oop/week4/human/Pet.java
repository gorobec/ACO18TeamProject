package oop.week4.human;

import java.util.Arrays;

/**
 * Created by fmandryka on 12.02.2017.
 */
public class Pet {
    String name;
    int age;
    PetType petType;

    public Pet(String name, int age, PetType petType) {
        this.name = name;
        this.age = age;
        this.petType = petType;
    }

    public static enum PetType {DOG, CAT, TIGER, FISH}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append(name).append(", ").append(age).append(", ").append(petType).toString();
    }
}
