package week1.day2;

/**
 * Created by ksyashka on 22.01.2017.
 */
public class Manager extends Person {
    private String phoneNumber;
    private Coder coders[];

    public Manager(String name, String surname, int age, String phoneNumber, Coder[] coders) {
        super(name, surname, age);
        this.phoneNumber = phoneNumber;
        this.coders = coders;
    }

    @Override
    public String asString() {
        return String.format("Name - %s, phone number - %s", name, phoneNumber);
    }

    public void showInfo() {
        System.out.println(this.asString());
        for (int i = 0; i < coders.length; i++)
            System.out.println(coders[i].asString());
    }

    @Override
    public void work(){
        System.out.println("I'm manager!");
        for (int i = 0; i < coders.length; i++)
            coders[i].work();
    }
}
