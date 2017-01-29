package task4_Interface.Doctor;

/**
 * Created by Sherlock on 28.01.2017.
 */
public class Neurosurgeon extends Surgeon {

    public Neurosurgeon(String name, int age, int exp) {
        super(name, exp);
    }

    @Deprecated
    public void getWorkType() {
        System.out.println("I'm a Neurosurgeon");

    }
}




