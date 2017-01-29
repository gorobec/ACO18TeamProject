package oop.weak1.inheritance;

/**
 * Created by fmandryka on 22.01.2017.
 */
public class Middle extends Codder {
    private String progLanguage;

    public Middle(String name, String surname, int age, String progLanguage) {
        super(name, surname, age, progLanguage);
    }

    @Override
    public String asString() {
        return String.format("Name = %s, language = %s", name, progLanguage);
    }

    public void work() {
        System.out.println("I'm Middle. I'm working!");
    }
}
