package week1.day2;

/**
 * Created by User on 22.01.2017.
 */
public class Codder extends Person {

   protected String progLang;

    public Codder(String name, String surName, int age, String progLang) {
        super(name, surName, age);
        this.progLang = progLang;
    }
}
