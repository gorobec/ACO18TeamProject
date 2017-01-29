package oop.weak1.task_6_physician;

import java.util.Formatter;

/**
 * Created by Администратор on 26.01.2017.
 */
public class Surgeon implements Physician {

    private String name;
    private String[] diagnoses; //в реальном задании можно было сделать Map (жалоба-диагноз), но я упростил.
    private String[] skills;

    public Surgeon(String name, String[] diagnoses, String[] skills) {
        this.name = name;
        this.diagnoses = diagnoses;
        this.skills = skills;
    }


    public String getName() {
        return name;
    }

    public String[] getDiagnoses() {
        return diagnoses;
    }

    public String[] getSkills() {
        return skills;
    }

    @Override
    public String examinePatient(Patient patient) {

        StringBuilder sb = new StringBuilder();

        if (patient != null & diagnoses != null) {

            for (int i = 0; i < patient.getHealthComplaints().length; i++) {
                for (int j = 0; j < diagnoses.length; j++) {

                    if (patient.getHealthComplaints()[i].equals(diagnoses[j])) {
                        sb.append(diagnoses[j] + ", ");
                    }
                }
            }
        }
        if (sb.length() == 0) {
            return "Patient " + patient.getName()+ " has no surgery disorders";
        } else {
            return "Patient " + patient.getName()+ " has next surgery disorders " + sb;
        }
    }

    @Override
    public String giveAdvice(Patient patient) {
        Formatter fm = new Formatter();
        fm.format("Surgeon %s is giving some advice to patient %s...", name, patient.getName());
        return fm.toString();
    }

    @Override
    public String provideMedicalAssistance(Patient patient) {
        Formatter fm = new Formatter();
        fm.format("Surgeon %s is doing surgery to patient %s...", name, patient.getName());
        return fm.toString();
    }
}
