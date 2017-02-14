package week4;

import java.util.List;

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
