package week1.task2;

/**
 * Created by ksyashka on 23.01.2017.
 */
public class Puppy  extends Dog {

    public Puppy (String name, String breed){
        super(name, breed);
    }

    @Override
    public String speak(){
        return "Woof! Woof! Woof!";
    }
}

