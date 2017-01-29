package week1.homework.doctor;

import week1.homework.animal.Dog;

/**
 * Created by serhiim on 26-Jan-17.
 */
public abstract class Surgeon implements Doctor{
    protected String name;
    protected int experience;
    protected int surgeryCount;

    public Surgeon(String name, int experience, int surgeryCount) {
        this.name = name;
        this.experience = experience;
        this.surgeryCount = surgeryCount;
    }

    public String getName() {
        return name;
    }
}
