package week2.homework.cat;

import java.util.ArrayList;

/**
 * Created by serhiim on 21-Jan-17.
 */
public class Cat {

    private String name;
    private int age;
    public static ArrayList<Cat> cats = new ArrayList<>();

    public Cat(String name, int age){
        this.name = name;
        this.age = age;
        cats.add(this);
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) return;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age == 0) return;
        this.age = age;
    }

    public static void printAllCats() {
        for (int i = 0; i < cats.size(); i++) {
            System.out.println(cats.get(i).toString());
        }
    }

    @Override
    public String toString(){
        return String.format("Cat name - %s, cat age - %d", name, age);
    }


}
