package oop.week4.human;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by fmandryka on 12.02.2017.
 */
public class Run {
    
    private static final int PET_LIMIT = 3;
    private static final int MIN_AGE = 18;
    private static final int MAX_AGE = 50;

    public static void main(String[] args) {

        Stream<Human> humStream = Stream.generate(Run::generateHuman).limit(20).peek((el) -> System.out.print(el + " "));
        
        List<Human> hList = humStream.collect(Collectors.toList());

        System.out.println();

// other Stream test
        long count = Stream.generate(() -> Math.random() * 100)
                .limit(100)
                .map(Double::intValue)
                .filter((el) -> el % 2 == 0)
                .sorted(Comparator.<Integer>naturalOrder()).peek((el) -> System.out.print(el + " ")).count();

        System.out.println(count);

    }

    private static Human generateHuman() {
        return new Human(getCity(),getName(),getAge(),getPets());
    }

    private static String getCity() {
        String[] cities = {"Kyiv", "Odessa", "Kharkiv", "Sumy", "Poltava", "Lviv"};
        return cities[getRandomIndex(cities.length)];
    }

    private static String getName() {
        String[] names = {"Oleg", "Maks", "Vlad", "Sergii", "Anna", "Olga", "Andrii", "Evgenii", "Ivan", "Kolia", "Yana", "Jack"};
        return names[getRandomIndex(names.length)];
    }

    private static int getAge() {
        return MIN_AGE + getRandomIndex(MAX_AGE - MIN_AGE);
    }

    public static List<Pet> getPets(){

        String[] petName = {"Bobik", "Sharik", "Murzik"};

        List<Pet> pets = new ArrayList<>();

        for (int i = 0; i < PET_LIMIT; i++) {
            pets.add(new Pet(petName[getRandomIndex(petName.length)], getRandomIndex(10), Pet.PetType.values()[getRandomIndex(Pet.PetType.values().length)]));
        }

        return pets;
    }

    public static int getRandomIndex(int maxIndex) {
        return (int) (Math.random() * maxIndex);
    }
}
