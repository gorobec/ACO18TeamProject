package oop.weak1.task_6_physician;

import java.util.Formatter;

/**
 * Created by Администратор on 26.01.2017.
 */
public class Neurosurgeon extends Surgeon {


    public Neurosurgeon(String name, String[] diagnoses, String[] skills) {
        super(name, diagnoses, skills);
    }

    @Override
    public String giveAdvice(Patient patient) {
        Formatter fm = new Formatter();
        fm.format("Neurosurgeon %s is giving some useless advice to patient %s and take his money...", getName(), patient.getName());
        return fm.toString();
    }

    @Override
    public String provideMedicalAssistance(Patient patient) {
        Formatter fm = new Formatter();
        fm.format("Neurosurgeon %s is doing needless surgery on nervous system to patient %s...", getName(), patient.getName());
        return fm.toString();
    }

}
