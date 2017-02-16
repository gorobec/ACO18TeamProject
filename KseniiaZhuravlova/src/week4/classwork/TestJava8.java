package week4.classwork;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by ksyashka on 12.02.2017.
 */
public class TestJava8 {
    private static final int MIN_AGE = 18;
    private static final int MAX_AGE = 45;

    public static void main(String[] args) {

        // Supplier -> Object get(){}
    /*    long count = Stream.generate(() -> Math.random() * 100)
                .limit(100)
                .map(Double::intValue)
                .filter((el) -> el % 2 == 0)
                .sorted(Comparator.<Integer>naturalOrder()).peek((el) -> System.out.print(el + "")).count();
        System.out.println();

        System.out.println(count);*/

     /*   Function<Human, Human> addAgePets = new Function<Human, Human>() {
            @Override
            public Human apply(Human human) {
                return human.addPetsAge(2);
            };
        };*/

      //  Function<Human, Human> addAgePets = human -> human.addPetsAge(2);

      /*  Predicate<Human> kievPredicate = new Predicate<Human>() {

            @Override
            public boolean test(Human human) {
                return human.getCity().equals("Kiev");
            }
        };*/

        //Predicate<Human> kievPredicate = human -> human.getCity().equals("Kiev");

        Object[] humans = Stream.generate(TestJava8::generateHuman)
                        .limit(10)
                        .sorted(new NameComparator<>())
                        .peek(human -> System.out.println(human))
                        .map(human -> human.addPetsAge(2))
                        .filter(human -> human.getCity().equals("Kiev"))
                        .toArray();
        for (int i=0; i<humans.length;i++) {
            System.out.println(humans[i]);
        }

    }

    private static Human generateHuman() {
        return new Human(genName(), genAge(), genCity(), genPets());
    }

    private static List<Pet> genPets() {
        List<Pet> pets = new LinkedList<>();
        pets.add(new Pet(genPetName(), genAge(), genPetType()));
        pets.add(new Pet(genPetName(), genAge(), genPetType()));
        pets.add(new Pet(genPetName(), genAge(), genPetType()));
        return pets;

    }

    private static PetType genPetType() {
        PetType[] petTypes = {PetType.DOG, PetType.CAT, PetType.PARROT};
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
