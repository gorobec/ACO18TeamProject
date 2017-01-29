package week1day2.task2;

/**
 * Created by Валерий on 22.01.2017.
 */
public class Coder extends Person {
    private String progarammingLanguage;

    public Coder(String name, String surname, int age, String progarammingLanguage) {
        super(name, surname, age);
        this.progarammingLanguage = progarammingLanguage;
    }

    @Override
    public String asString(){
       return String.format("Name -> %s, language -> %s", name, progarammingLanguage);
    }

    public void work(){
        System.out.println("I`m coding!");
    }
}
