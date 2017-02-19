package week4;

import javafx.scene.effect.PerspectiveTransform;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Serhii Bilobrov
 * @since 1.7
 */
public class StreamTest {

    public static final int MIN_AGE = 18;
    public static final int MAX_AGE = 50;

    // Supplier -> Object get(){}
    public static void main(String[] args) {

        long count = Stream.generate(() -> Math.random() * 100)
                .limit(100)
                .map(Double::intValue)
                .filter((el) -> el % 2 == 0)
                .sorted(Comparator.<Integer>naturalOrder()).peek((el) -> System.out.print(el + " ")).count();
        System.out.println();

        System.out.println(count);
        //Stream<Human> humanStream = Stream.generate(StreamTest::generateHuman).limit(20);


        //List<Human> humanList = humanStream.collect(Collectors.toList());

    }

    private static Human generateHuman() {

        Human human = new Human(genName(), genAge(), genCity(), genPets());

        return null;
    }

    private static List<Pet> genPets() {

        return null;
    }

    private static void genPetName() {

    }

    private static String genCity() {
        String[] cities = {"Kiev", "Odessa", "Kharkiv"};
        return cities[genRanIndex(cities.length)];
    }

    private static int genAge() {
        return MIN_AGE + genRanIndex(MAX_AGE - MIN_AGE);
    }

    private static String genName() {
        String[] names = {"Ivan", "Kolia", "Oleg", "Yana", "Jack"};
        return names[genRanIndex(genRanIndex(names.length))];

    }

    private static int genRanIndex(int size) {
        return (int) (Math.random() * size);
    }
}

