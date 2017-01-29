package week1.taskinterfaces.doctor;

/**
 * Created by ksyashka on 25.01.2017.
 */
public class Surgeon implements Doctor {
    private String name;
    private int experience;

    public Surgeon(String name, int experience) {
        this.name = name;
        this.experience = experience;
    }

    @Override
    public void work() {
        System.out.println("I'm working.");
    }

    @Override
    public String toString() {
        return String.format("Name - %6s, expirience - %2d. Surgeon. ", name, experience);
    }
}
