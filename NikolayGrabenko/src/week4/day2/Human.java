package week4.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Human {

    private String city;
    private String name;
    private int age;
    private List<Pet> pets;

    //    Stream<String> stream = Stream.generate(() -> "test").limit(10);
//    String[] strArr = stream.toArray(String[]::new);
//    System.out.println(Arrays.toString(strArr));

    public String generateCity() {
        String[] cities = {"Kiev", "Lviv", "Dnipro", "New York"};
        city = cities[(int) Math.random() * 3];
        return city;
    }

    public String generateName() {
        String[] names = {"Andrey", "Bob", "Jack", "David"};
        name = names[(int) Math.random() * 3];
        return name;
    }

    public int generateAge() {
        return age = (int) Math.random() * 10 + 20;
    }

    public Human generateHuman() {

        Human human = new Human();
        human.name = generateName();
        human.city = generateCity();
        human.age = generateAge();
//        human.pets = new ArrayList<>();
        return human;
    }

}
