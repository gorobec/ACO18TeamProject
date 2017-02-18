package ACO.week4.stream_practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by v21k on 12.02.17.
 */
public class Human {
    private String city;
    private String name;
    private int age;
    private List<Pet> pets = new ArrayList<>();

    public Human(String city, String name, int age, List<Pet> pets) {
        this.city = city;
        this.name = name;
        this.age = age;
        this.pets = pets;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
