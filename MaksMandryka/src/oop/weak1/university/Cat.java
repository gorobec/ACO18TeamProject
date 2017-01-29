package oop.weak1.university;

/**
 * Created by fmandryka on 21.01.2017.
 */
public class Cat {
    private String name;
    private int age;


    public Cat (String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) return;
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String asString (){
        String output;
        output = "Name = " + name + " age = " + age;
        return output;
    }

}
