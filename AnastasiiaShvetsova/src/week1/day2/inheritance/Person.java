package week1.day2.inheritance;

/**
 * Created by gorobec on 22.01.17.
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


    public void work(){
        System.out.println("I'm working");
    }

    public String asString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}
