package week1.day2.Company;

import java.util.Arrays;

/**
 * Created by serhiim on 22-Jan-17.
 */
public class Manager extends Person {
    private Coder[] coders;

    public Manager() {
    }

    public Manager(String name, String surname, int age, Coder[] coders) {
        super(name, surname, age);
        this.coders = coders;
    }

    @Override
    public String asString(){
        return String.format("Manager name - %s, manager coders: \n%s", name, showCoders());
    }

    public String showCoders(){
        String codersString = "";
        for (int i = 0; i < coders.length; i++) {
            codersString += "Coder "+ (i+1) + "\n" + coders[i].asString() + "\n";
        }
        return codersString;
    }

    @Override
    public void work() {
        System.out.println("I am manager.");
        for (int i = 0; i < coders.length; i++) {
            coders[i].work();

        }
    }
}
