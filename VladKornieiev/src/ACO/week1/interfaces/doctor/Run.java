package ACO.week1.interfaces.doctor;

/**
 * Created by v21k on 25.01.17.
 */
public class Run {
    public static void main(String[] args) {
        Surgeon surgeon = new Surgeon();
        surgeon.treat();
        surgeon.writePrescription();

        Neurosurgeon neurosurgeon = new Neurosurgeon();
        neurosurgeon.treat();
        neurosurgeon.writePrescription();
    }
}
