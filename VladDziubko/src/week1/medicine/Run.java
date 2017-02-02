package week1.medicine;

/**
 * Created by Reed on 25.01.2017.
 */
public class Run {
    public static void main(String[] args) {
        Neurosurgeon neurosurgeon = new Neurosurgeon();
        System.out.println(neurosurgeon.doctorType());
        System.out.println("*******************");
        Surgeon surgeon = new Surgeon();
        System.out.println(surgeon.doctorType());
    }
}
