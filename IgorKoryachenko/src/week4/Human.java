package week4;

import java.util.ArrayList;
import java.util.List;

public class Human {

    String name;
    int age;
    String city;
    List pets;


    public Human(String name, int age, String city, ArrayList pets) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.pets = pets;
    }

    public Human() {
    }

    List generate(List list){
        for (int i = 0; i < 20; i++) {
            Human pets = new Human();
            list.add(pets);
        }
        return list;
    }
}
