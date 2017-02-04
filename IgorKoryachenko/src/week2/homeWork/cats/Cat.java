package week2.homeWork.cats;

import java.util.ArrayList;

/**
 * Created by Игорь on 03.02.2017.
 */
public class Cat {
    private String name;
    private int age;

    static ArrayList<Cat> cats = new ArrayList<>();
    int count = 0;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Cat() {
    }

     boolean addCat(Cat cat){
        cats.add(cat);
        count++;
        return true;
    }

    public String printCats(){
        String str = "";
        for(Cat c: cats){
            str += c.toString() + "\n";
        }
        return str;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


}
