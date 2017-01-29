package week1.day2.inheritance;

/**
 * Created by gorobec on 22.01.17.
 */
public class Coder extends Person{

    private String programmingLanguage;

    public Coder(String name, String surname, int age, String programmingLanguage) {
        super(name, surname, age);
        this.programmingLanguage = programmingLanguage;
    }

    public void work(){
        System.out.println("I'm coder, and I'm working");
    }

    @Override
    public String asString(){
        return String.format("Name - %s, language - %s", name, programmingLanguage);
    }


}
