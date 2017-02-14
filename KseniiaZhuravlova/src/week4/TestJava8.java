package week4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static week4.PetType.DOG;

/**
 * Created by ksyashka on 12.02.2017.
 */
public class TestJava8 {
    private static final int MIN_AGE = 18;
    private static final int MAX_AGE = 45;

    public static void main(String[] args) {

        Stream<Pet> petsStream = Stream.generate(() -> new Pet("Bob", 3, DOG)).limit(4);
        List<Pet> pets = petsStream.collect(Collectors.toList());

        Stream<Human> humansStream = Stream.generate(() -> new Human("Karl", 23, "Kiev", pets)).limit(10);
        List<Human> humans = humansStream.collect(Collectors.toList());
        System.out.println(humans.get(i));
        //humans.stream().filter( )
    }

    private static Human generateHuman() {
        Human human = new (genName(), genAge(), genCity(), genPets());
        return human;
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
