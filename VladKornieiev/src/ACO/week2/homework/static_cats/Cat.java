package ACO.week2.homework.static_cats;

import java.util.ArrayList;

/**
 * Created by v21k on 30.01.17.
 */
public class Cat {
    private String name;
    private int age;
    private static ArrayList<Cat> cats = new ArrayList<>();

    public Cat(){
        name = "Default cat";
        age = 1;
        cats.add(this);
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        cats.add(this);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static void printCats(){
        for (Cat cat: cats) {
            System.out.printf("Cat name - %s, age - %d\n", cat.getName(), cat.getAge());
        }
    }
}
