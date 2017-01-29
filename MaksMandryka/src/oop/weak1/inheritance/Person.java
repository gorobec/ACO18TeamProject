package oop.weak1.inheritance;

/**
 * Created by fmandryka on 22.01.2017.
 */
public class Person {
    protected String name;
    protected String surname;
    protected int age;

    public Person() {
    }


    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String asString() {
        String output;
        output = "Name = " + name + " surname = " + surname + " age " + age;
        return output;
    }

    public void work() {
        System.out.println("I'm working!");
    }
}
