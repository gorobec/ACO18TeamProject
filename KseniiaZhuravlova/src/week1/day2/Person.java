package week1.day2;

/**
 * Created by ksyashka on 22.01.2017.
 */
public class Person {
    protected String name;
    private String surname;
    private int age;

    public Person(){

    }

    public Person(String name, String surname, int age){
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String asString(){
        return String.format("Peron name - %s, surname - %s, age - %d", name, surname, age);
    }

    public void work(){
        System.out.println ("I'm working!");
    }
}
