package week4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static week4.PetType.CAT;
import static week4.PetType.DOG;
import static week4.PetType.PARROT;

/**
 * Created by ksyashka on 12.02.2017.
 */
public class TestJava8 {
    private static final int MIN_AGE = 18;
    private static final int MAX_AGE = 45;

    public static void main(String[] args) {


        Stream<Human> humansStream = Stream.generate(TestJava8::generateHuman).limit(10);
        List<Human> humans = humansStream.collect(Collectors.toList());
        for (Human h:humans) {
            System.out.println(h);
        }

    }

    private static Human generateHuman() {
        return new Human(genName(), genAge(), genCity(), genPets());
    }

    private static List<Pet> genPets() {
        List<Pet> pets = new LinkedList<>();
        pets.add(new Pet (genPetName(),genAge(),genPetType()));
        pets.add(new Pet (genPetName(),genAge(),genPetType()));
        pets.add(new Pet (genPetName(),genAge(),genPetType()));
        return pets;

    }

    private static PetType genPetType() {
        PetType[] petTypes = {DOG, CAT, PARROT};
        return petTypes[genRanIndex(petTypes.length)];
    }

    private static String genPetName() {
        String[] names = {"Sharik", "Vas'ka", "Murka", "Savelii", "Bob"};
        return names[genRanIndex(names.length)];
    }

    private static String genCity() {
        String[] names = {"Kiev", "Odessa", "Kharkiv"};
        return names[genRanIndex(names.length)];
    }

    private static int genAge() {
        return MIN_AGE + genRanIndex(MAX_AGE - MIN_AGE);
    }

    private static String genName() {
        String[] names = {"Ivan", "Kolia", "Oleg", "Yana", "Jack"};
        return names[genRanIndex(names.length)];
    }

    private static int genRanIndex(int size) {
        return (int) (Math.random() * size);
    }
}
