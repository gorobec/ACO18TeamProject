package week1.day2.inheritance;

/**
 * Created by gorobec on 22.01.17.
 */
public class Manager extends Person {
    private Coder[] coders;

    public Manager(String name, String surname, int age, Coder[] coders) {
        super(name, surname, age);
        this.coders = coders;
    }

    public void work(){
        System.out.println("I'm manager");
        for (int i = 0; i < coders.length; i++) {
            coders[i].work();
        }
    }

}
