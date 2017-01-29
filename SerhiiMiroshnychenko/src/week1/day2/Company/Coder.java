package week1.day2.Company;

/**
 * Created by serhiim on 22-Jan-17.
 */
public class Coder extends Person{
    private String programmingLanguage;

    public Coder() {
    }

    public Coder(String name, String surname, int age, String programmingLanguage) {
        super(name, surname, age);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public String asString(){
        return String.format("Person name - %s, Programing language - %s", name, programmingLanguage);
    }

    @Override
    public void work(){
        System.out.println("I am coder. I am working");
    }
}
