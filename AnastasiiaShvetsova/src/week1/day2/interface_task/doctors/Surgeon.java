package week1.day2.interface_task.doctors;

/**
 * Created by anastasiia.shvetsova on 1/25/2017.
 */
public class Surgeon implements Doctor{
    private String name;

    public Surgeon(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void treat() {
        System.out.println("I'm doctor. I do people surgery");
    }
}
