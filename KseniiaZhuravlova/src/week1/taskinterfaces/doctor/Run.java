package week1.taskinterfaces.doctor;

/**
 * Created by ksyashka on 25.01.2017.
 */
public class Run {
    public static void main(String[] args) {
        Doctor surgeon = new Surgeon("House", 14);
        Doctor neurosurgeon = new Neurosurgeon("Smith", 19);
        Doctor plasticSurgeon = new PlasticSurgeon("Adams", 8);

        Doctor[] doctors = {surgeon, neurosurgeon, plasticSurgeon};

        Hospital hospital = new Hospital(doctors);
        hospital.showDoctors();
        hospital.workDoctors();
    }
}
