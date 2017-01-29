package week1.classWork;

/**
 * Created by Игорь on 22.01.2017.
 */
public class Manager extends Person {
    private Coder[] coders;
    private String region;



    public Manager(String name, String surname, int age, Coder[] coders, String region) {
        super(name, surname, age);
        this.coders = coders;
        this.region = region;
    }

    @Override
    public String asString() {
        return super.asString() + "  Region - " + region;
    }
}
