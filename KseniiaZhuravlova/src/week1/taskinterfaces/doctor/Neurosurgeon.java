package week1.taskinterfaces.doctor;

/**
 * Created by ksyashka on 25.01.2017.
 */
public class Neurosurgeon extends Surgeon {

    public Neurosurgeon(String name, int experience) {
        super(name, experience);
    }

    @Override
    public String toString() {
        return super.toString() + "Neurosurgeon.";
    }
}
