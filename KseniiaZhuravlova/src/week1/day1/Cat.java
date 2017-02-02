package week1.day1;

import sun.invoke.empty.Empty;

import java.util.ArrayList;

/**
 * Created by ksyashka on 21.01.2017.
 */
public class Cat {
    private String name;
    private int age;
    public static ArrayList cats = new ArrayList();
    public  Cat(){}
    public Cat(String name, int age){
        this.name = name;
        this.age = age;
        cats.add(this);
    }

    public String toString(){
        return String.format("Cat name - %s, age - %d", name, age);
    }

    public String getName(){
        return name;
    }

    public int getAge() {
        return age;
    }


    public static void printCats(){
        for (int i=0;i<cats.size();i++)
            System.out.println(cats.get(i));
    }

}