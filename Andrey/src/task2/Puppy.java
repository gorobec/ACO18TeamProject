package task2;

/**
 * Created by Sherlock on 27.01.2017.
 */
public class Puppy extends Dog {

    public Puppy(String name, int age) {
        super(name, age);
    }
public void printNameAge(){
    System.out.println("My name is " + super.name + " ");
}
}
