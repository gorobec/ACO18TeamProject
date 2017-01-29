package oop.weak1.inheritance;

/**
 * Created by fmandryka on 22.01.2017.
 */
public class Codder extends Person {
    private String progLanguage;

    public Codder(String name, String surname, int age, String progLanguage) {
        super(name, surname, age);
        this.progLanguage = progLanguage;
    }

    @Override
    public String asString() {
        return String.format("Name = %s, language = %s", name, progLanguage);
    }

}
