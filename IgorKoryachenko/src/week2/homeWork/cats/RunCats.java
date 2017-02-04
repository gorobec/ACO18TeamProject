package week2.homeWork.cats;

/**
 * Created by Игорь on 03.02.2017.
 */
public class RunCats {

    public static void main(String[] args) {


        Cat cat = new Cat();

        cat.addCat(new Cat("Georg", 5));
        cat.addCat(new Cat("Anna", 3));
        cat.addCat(new Cat("Ludovik", 4));

        System.out.println(cat.printCats());
        System.out.println();
    }
}
