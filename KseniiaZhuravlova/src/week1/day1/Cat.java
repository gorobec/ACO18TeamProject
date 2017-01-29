package week1.day1;

import sun.invoke.empty.Empty;

/**
 * Created by ksyashka on 21.01.2017.
 */
public class Cat {
    private String name;
    private int age;

    public Cat(){};
    public Cat(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String asString(){
        return String.format("week1.day1.Cat name - %s, age - %d", name, age);
    }

    public String getName(){
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name){
        if (name == null || name.length()==0) return;
        // isEmpty - ?
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

}