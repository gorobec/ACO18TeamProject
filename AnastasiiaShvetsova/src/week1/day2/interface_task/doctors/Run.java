package week1.day2.interface_task.doctors;

/**
 * Created by anastasiia.shvetsova on 1/25/2017.
 */
public class Run {
    public static void main(String[] args) {
        Doctor surgeon  = new Surgeon("Jack");

        Neurosurgeon neurosurgeon = new Neurosurgeon("Nick");
        neurosurgeon.treat();
        surgeon.treat();
    }
}
