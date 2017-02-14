package week1.day2;

/**
 * Created by User on 22.01.2017.
 */
public class Manager extends Person {

    private int jobExp;
    Codder[] codders;

    public Manager(String name, String surName, int age, int jobExp,Codder [] codders) {
        super(name, surName, jobExp);
        this.jobExp = jobExp;
        this.codders = codders;
    }

    @Override
    public String asString() {
        return String.format("name - %8s, surName - %12s, age - %d, experiance - %d ",name,surName,age,jobExp);
    }
}
