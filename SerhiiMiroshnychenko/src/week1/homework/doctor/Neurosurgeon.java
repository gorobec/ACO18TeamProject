package week1.homework.doctor;

/**
 * Created by serhiim on 26-Jan-17.
 */
public class Neurosurgeon extends Surgeon {
    public Neurosurgeon(String name, int experience, int surgeryCount) {
        super(name, experience, surgeryCount);

    }


    @Override
    public String getSpecialisation() {
        return "Neurosurgeon";
    }

    @Override
    public int getExperience() {
        return experience;
    }

    @Override
    public int getSurgeryCount() {
        return surgeryCount;
    }
}
