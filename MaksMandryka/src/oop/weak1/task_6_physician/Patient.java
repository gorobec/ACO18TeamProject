package oop.weak1.task_6_physician;

/**
 * Created by fmandryka on 26.01.2017.
 */
public class Patient {

    private String name;
    private String[] healthComplaints;

    public Patient(String name, String[] healthComplaints) {
        this.name = name;
        this.healthComplaints = healthComplaints;
    }

    public String getName() {
        return name;
    }

    public String[] getHealthComplaints() {
        return healthComplaints;
    }
}
