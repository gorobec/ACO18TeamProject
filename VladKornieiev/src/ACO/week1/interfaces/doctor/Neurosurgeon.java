package ACO.week1.interfaces.doctor;

/**
 * Created by v21k on 25.01.17.
 */
public class Neurosurgeon implements Doctor {
    @Override
    public void treat() {
        System.out.println("I will treat you nervous system");
    }

    @Override
    public void writePrescription() {
        System.out.println("Here are some drugs from neurosurgeon");
    }
}
