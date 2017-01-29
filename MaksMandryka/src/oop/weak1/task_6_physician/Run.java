package oop.weak1.task_6_physician;

/**
 * Created by fmandryka on 26.01.2017.
 */
public class Run {
    public static void main(String[] args) {

        String[] diagnoses = {"Parkinson's disease", "Alzheimer's disease", "dementia", "Huntington's disease", "amyotrophic lateral sclerosis", "mitochondria disease"};
        String[] skills = {"invasive methods for nervous system", "minimally-invasive methods for nervous system", "non-invasive surgical methods for nervous system"};

        Surgeon surgeon1 = new Neurosurgeon("Andrew", diagnoses, skills);
        String[] compliants = {"Alzheimer's disease"};

        Patient patient = new Patient("Alex", compliants);

        System.out.println(surgeon1.examinePatient(patient));
        System.out.println(surgeon1.giveAdvice(patient));
        System.out.println(surgeon1.provideMedicalAssistance(patient));

    }
}
