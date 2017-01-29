package week1.day2.Company;

/**
 * Created by serhiim on 22-Jan-17.
 */
public class Person {
    protected String name;
    private String surname;
    private int age;

    public Person() {
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String asString(){
        return String.format("Person name - %s, Person surname - %s, age - %d", name, surname, age);
    }

    public void work(){
        System.out.println("I am working.");
    }
}
