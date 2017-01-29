package week1day2.task2;

/**
 * Created by Валерий on 22.01.2017.
 */
public class Manager extends Person {
    protected Coder[] coders;

    public Manager(String name, String surname, int age, Coder[] coders){
        super(name, surname, age);
        this.coders = coders;
    }

    public Coder[] getCoders(){
        return coders;
    }
    public String asString(){
        return String.format("%s %s", name, surname);
    }

    public void showCoders(){
        for (int i = 0; i < coders.length; i++) {
            System.out.println(coders[i].asString());
        }
    }

    public void work(){
        System.out.println("I`m manager!");
    }
}
