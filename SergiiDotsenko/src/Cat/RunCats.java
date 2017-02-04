package cat;

import java.util.Arrays;

/**
 * Created by SDotsenko on 30.01.2017.
 */
public class RunCats {
    public static void main(String[] args) {
        Cat cat1 = new Cat("cat1");
        Cat cat2 = new Cat("cat2");
        Cat cat3 = new Cat("cat3");
        Cat cat4 = new Cat("cat4");
        Cat cat5 = new Cat("cat5");

        Cat.printAllCats();
        System.out.println(Arrays.toString(Cat.catStore.toArray()));
        Cat.catStore.forEach(currentCat -> System.out.println(currentCat));
    }
}
