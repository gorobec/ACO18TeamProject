package week1.day2;

/**
 * Created by ksyashka on 22.01.2017.
 */
public class Coder extends Person {
    private String programmingLanguage;
    public Coder(String name, String surname, int age, String programmingLanguage){
        super (name, surname, age);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public String asString(){
        return String.format("Peron name - %s, language - %s", name, programmingLanguage);
    }

    @Override
    public void work(){
        System.out.println("I'm coder. I'm working!");
    }
}
