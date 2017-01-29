package week1.homework.animal;

/**
 * Created by serhiim on 23-Jan-17.
 */
public class Puppy extends Dog{
    @Override
    public void jump() {
        System.out.println(name + " is jumping");
    }

    @Override
    public void ran() {
        System.out.println(name + " is running");
    }

    @Override
    public void bite() {
        System.out.println(name + " is biting");
    }

    @Override
    public void voice() {
        System.out.println(name + " Wof wof");
    }

    @Override
    public void printName() {
        super.printName();
    }

}
