package task2;

/**
 * Created by Sherlock on 27.01.2017.
 */
public class Dog extends Animal {

    public Dog(String name, int age) {
        super(name, age);
    }

    public void jump() {
        System.out.println("I'm jumping");
    }
    public  void run(){
        System.out.println("I'm runing");
    }
    public void voice(){
        System.out.println("Gav - gav ");
    }
    public  void bite(){
        System.out.println("I'm biting");
    }
}
