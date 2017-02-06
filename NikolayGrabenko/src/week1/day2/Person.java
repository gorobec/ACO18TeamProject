package week1.day2;

/**
 * Created by User on 22.01.2017.
 */
public class Person {

    protected String name;
    protected String surName;
    protected int age;

    public Person() {
    }

    public Person(String name, String surName, int age) {
        this.name = name;
        this.surName = surName;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String asString (){
        return String.format("name - %8s, surName - %12s, age - %d",name,surName,age);
    }
}
