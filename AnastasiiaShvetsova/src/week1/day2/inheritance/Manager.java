package week1.day2.inheritance;

/**
 * Created by gorobec on 22.01.17.
 */
public class Manager extends Person {
    private int experience;
    private Coder[] coders;

    public Manager(String name, String surname, int age, int experience, Coder[] coders ){
        super(name, surname, age);
        this.experience = experience;
        this.coders = coders;
    }

    @Override
    public String asString() {
        return (String.format("Manager name - %s, surname -%s, age - %d, experience - %d ", name, surname, age, experience));
    }

    @Override
    public void work() {
        System.out.println("i'm manager");
        for(int i=0; i<coders.length; i++){
            coders[i].work();
        }
    }

    public void showCoders(){
        for(int i=0; i<coders.length; i++){
            System.out.println(coders[i].asString());
        }
    }

}
