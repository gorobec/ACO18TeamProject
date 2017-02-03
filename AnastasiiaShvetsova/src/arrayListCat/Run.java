package arrayListCat;

import static arrayListCat.Cat.cats;

/**
 * Created by anastasiia.shvetsova on 2/3/2017.
 */
public class Run {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Bella", 11);
        Cat cat2 = new Cat("Chloe", 12);
        Cat cat3 = new Cat("Luna", 1);
        Cat cat4 = new Cat("Oliver",2);
        Cat cat5 = new Cat("Lucy",3);
        Cat cat6 = new Cat("Jasper",4);
        Cat cat7 = new Cat("Tiger",6);
        Cat cat8 = new Cat("Lily",7);
        Cat cat9 = new Cat("Kitty",7);
        Cat cat10 = new Cat("Simba",9);

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
