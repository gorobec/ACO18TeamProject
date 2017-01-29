package week1.day2.interface_task.doctors;

/**
 * Created by anastasiia.shvetsova on 1/25/2017.
 */
public class Neurosurgeon extends Surgeon{

    public Neurosurgeon(String name) {
        super(name);
    }

    @Override
    public void treat() {
        System.out.println("I'm Neurosurgeon. " + "My name is " + this.toString());
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
