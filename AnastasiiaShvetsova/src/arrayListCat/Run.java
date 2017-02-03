package arrayListCat;

import static arrayListCat.Cat.cats;

/**
 * Created by anastasiia.shvetsova on 2/3/2017.
 */
public class Run {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Bella");
        Cat cat2 = new Cat("Chloe");
        Cat cat3 = new Cat("Luna");
        Cat cat4 = new Cat("Oliver");
        Cat cat5 = new Cat("Lucy");
        Cat cat6 = new Cat("Jasper");
        Cat cat7 = new Cat("Tiger");
        Cat cat8 = new Cat("Lily");
        Cat cat9 = new Cat("Kitty");
        Cat cat10 = new Cat("Simba");

        cats.add(cat1);
        cats.add(cat2);
        cats.add(cat3);
        cats.add(cat4);
        cats.add(cat5);
        cats.add(cat6);
        cats.add(cat7);
        cats.add(cat8);
        cats.add(cat9);
        cats.add(cat10);

        System.out.println(cats.toString());
    }
}
