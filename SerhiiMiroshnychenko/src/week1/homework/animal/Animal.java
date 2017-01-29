package week1.homework.animal;

/**
 * Created by serhiim on 23-Jan-17.
 */
public class Animal {
    protected String name;


    public void jump(){
        System.out.println("Animal is jumping");
    }

    public void ran(){
        System.out.println("Animal is running");
    }

    public void bite(){
        System.out.println("Animal is biting");
    }

    public void voice(){
        System.out.println("Animal voice");
    }

    public void printName(){
        System.out.println(name);
    }
}
