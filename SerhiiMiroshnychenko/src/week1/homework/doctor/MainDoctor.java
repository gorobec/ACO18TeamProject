package week1.homework.doctor;

/**
 * Created by serhiim on 26-Jan-17.
 */
public class MainDoctor {
    public static void main(String[] args) {
        Surgeon neurosurgeon = new Neurosurgeon("Ivan", 20, 140);

        System.out.println(neurosurgeon.getName());
        System.out.println(neurosurgeon.getSpecialisation());
        System.out.println(neurosurgeon.getExperience());
        System.out.println(neurosurgeon.getSurgeryCount());
    }
}
