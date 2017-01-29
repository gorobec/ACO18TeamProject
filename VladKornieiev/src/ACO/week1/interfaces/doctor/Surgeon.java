package ACO.week1.interfaces.doctor;

/**
 * Created by v21k on 25.01.17.
 */
public class Surgeon implements Doctor {
    @Override
    public void treat() {
        System.out.println("I will cut out you kidney :D");
    }

    @Override
    public void writePrescription() {
        System.out.println("List of some medicine...");
    }
}
