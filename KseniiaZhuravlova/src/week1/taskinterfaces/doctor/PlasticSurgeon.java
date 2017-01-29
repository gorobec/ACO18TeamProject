package week1.taskinterfaces.doctor;

/**
 * Created by ksyashka on 25.01.2017.
 */
public class PlasticSurgeon extends Surgeon {

    public PlasticSurgeon(String name, int experience) {
        super(name, experience);
    }

    @Override
    public String toString() {
        return super.toString() + "Plastic surgeon.";
    }
}
