package arrayListCat;

import java.util.ArrayList;

/**
 * Created by anastasiia.shvetsova on 2/3/2017.
 */
public class Cat {
    public static ArrayList<Cat> cats = new ArrayList<Cat>();
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return  "{Cat's name - " + name + ", age - " + age + "}";
    }
}
