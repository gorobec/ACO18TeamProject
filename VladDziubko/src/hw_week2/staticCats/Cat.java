package hw_week2.staticCats;

import java.util.ArrayList;

public class Cat {
    private String name;
    private int age;
    public static ArrayList<Cat> cats = new ArrayList<>();

    public Cat(String name, int age){
        this.name = name;
        this.age = age;
        cats.add(this);
    }

    public Cat(){
        name = "Some cat";
        age = 5;
        cats.add(this);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static ArrayList<Cat> printCats(){
        for (Cat cat : cats) {
            System.out.printf("%s, age -> %d\n", cat.getName(), cat.getAge());
        }
        return cats;
    }
}
