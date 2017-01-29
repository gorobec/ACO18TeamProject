package week1.day2.animal_task;

/**
 * Created by anastasiia.shvetsova on 1/23/2017.
 */
public class Puppy extends Dog {

    public Puppy(String name, int positionVertical, int positionHorizontal){
        super(name, positionVertical, positionHorizontal);
    }

    public void bit(){
        System.out.println("I can bit");
    }

    @Override
    public void sayGav() {
        System.out.println("I say gav gav gav");
    }
}
