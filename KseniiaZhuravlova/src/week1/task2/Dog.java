package week1.task2;

/**
 * Created by ksyashka on 23.01.2017.
 */
public class Dog  extends Animal {

    private String breed;

    public Dog (String name, String breed){
        super(name);
        this.breed = breed;
    }

    @Override
    public void showName(){
        System.out.print ("I'm dog. ");
        super.showName();
    }

    @Override
    public String toString(){
        return super.toString()+" "+breed;
    }

    public void jump(){
        System.out.println("I'm jumping");
    }

    public void run(){
        System.out.println("I'm runing");
    }

    public void bite(){
        System.out.println("I'm biting");
    }

    public String speak(){
        return "Woof!";
    }
}

