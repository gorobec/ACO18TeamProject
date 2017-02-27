package ACO.week1.puppy;

/**
 * Created by v21k on 24.01.17.
 */
public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    public void bark(){
        System.out.println("WOOF!!!");
    }

    public void jump(int times){
        System.out.printf("%s jumped %d times\n", this.getName(), times);
    }

    public void run(int distance){
        System.out.printf("%s run %d metres\n", this.getName(), distance);
    }

    public void bit(){
        System.out.println("I'm going com.bestBuy.to bite you!");
    }
}
