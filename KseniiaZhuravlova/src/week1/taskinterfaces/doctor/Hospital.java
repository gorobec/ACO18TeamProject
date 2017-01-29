package week1.taskinterfaces.doctor;

/**
 * Created by ksyashka on 25.01.2017.
 */
public class Hospital {
    Doctor doctors[];

    public Hospital(Doctor[] doctors) {
        this.doctors = doctors;
    }


    public void showDoctors() {
        if (doctors.length != 0)
            for (int i = 0; i < doctors.length; i++) {
                if (doctors[i] != null)
                    System.out.println(doctors[i]);
            }
    }

    public void workDoctors() {
        if (doctors.length != 0)
            for (int i = 0; i < doctors.length; i++) {
                if (doctors[i] != null)
                    doctors[i].work();
            }
    }
}
