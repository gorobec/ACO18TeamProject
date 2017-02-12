package ACO.week3.homework.week4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by v21k on 12.02.17.
 */
public class TestStreams {

    public static final int MIN_AGE = 20;
    public static final int MAX_AGE = 60;

    public static void main(String[] args) {
        List<Pet> pets = getPets();
        List<String> cities = generateCities();
        List<String> names = generateNames();

        // 1st task
        List<Human> humanList = generateHumanList(pets, cities, names);

        // 2nd task
        List<Human> humanFilter = humanList
                .stream()
                .filter(s -> s.getCity().equals("Kyiv")
                        && (s.getAge() >= 24 && s.getAge() <= 40))
                .collect(Collectors.toList());

        // 3rd
        List<Pet> petList = humanList
                .stream()
                .flatMap(s -> s.getPets()
                        .stream()
                        .filter(pet -> pet.getPetType().equals(PetType.DOG)))
                .collect(Collectors.toList());

    }

    private static List<Human> generateHumanList(List<Pet> pets, List<String> cities, List<String> names) {
        return Stream
                .generate(() -> new Human(getRandomCity(cities), getRandomName(names), getRandomAge(), pets))
                .limit(20).collect(Collectors.toList());
    }

    private static List<String> generateNames() {
        List<String> names = new ArrayList<>();
        names.add("Zhenia");
        names.add("Vlad");
        names.add("Kolia");
        return names;
    }

    private static List<Pet> getPets() {
        List<Pet> pets = new ArrayList<>();
        pets.add(new Pet("Lola", 6, PetType.CAT));
        pets.add(new Pet("Rola", 4, PetType.DOG));
        pets.add(new Pet("Cola", 1, PetType.DOG));
        pets.add(new Pet("Kola", 2, PetType.FISH));
        return pets;
    }

    private static List<String> generateCities() {
        List<String> cities = new ArrayList<>();
        cities.add("Kiev");
        cities.add("Kharkiv");
        cities.add("Kiev");
        return cities;
    }

    private static int getRandomAge() {
        return (int) (Math.random() * MAX_AGE + MIN_AGE);
    }

    private static String getRandomCity(List<String> cities) {
        return cities.get((int) (cities.size() * Math.random()));
    }

    private static String getRandomName(List<String> names) {
        return names.get((int) (names.size() * Math.random()));
    }
}