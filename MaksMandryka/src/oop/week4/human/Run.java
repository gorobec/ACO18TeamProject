package oop.week4.human;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by fmandryka on 12.02.2017.
 */
public class Run {
    public static void main(String[] args) {

        String[] cities = {"Kyiv", "Odessa", "Kharkiv", "Sumy", "Poltava", "Lviv"};
        String[] names = {"Oleg", "Maks", "Vlad", "Sergii", "Anna", "Olga", "Andrii", "Evgenii"};
        String[] petName = {"Bobik", "Sharik", "Murzik"};
        String[] petType = {"Cat", "Dog"};



        Stream<Human> humStream = Stream.generate(() -> new Human(cities[getRandomIndex(cities.length)], names[getRandomIndex(names.length)], getRandomIndex(50),
                getPets(petName,petType))).limit(20);

        List<Human> hList = humStream.collect(Collectors.toList());

        int i=5;

    }

    public static List<Pet> getPets(String[] petName, String[] petType){
        List<Pet> pets = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            pets.add(new Pet(petName[getRandomIndex(petName.length)], getRandomIndex(10), petType[getRandomIndex(petType.length)]));
        }

        return pets;
    }

    public static int getRandomIndex(int maxIndex) {
        return (int) (Math.random() * maxIndex);
    }
}
