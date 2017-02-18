package week4.classwork;

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

    public Human addPetsAge(int age){
        for (Pet p:pets) {
            p.setAge(p.getAge() + age);
        }
        return this;
    }

    @Override
    public String toString() {
     return String.format("Name - %s, age - %d, city - %s \n Pets: %s", name, age, city, pets);

    }
}
