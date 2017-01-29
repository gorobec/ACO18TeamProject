package week1.day2.animal_task;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Timer;

/**
 * Created by anastasiia.shvetsova on 1/23/2017.
 */
public class Dog extends Animal{
    private int positionVertical = 0;
    private int positionHorizontal = 0;

    public Dog(String name, int positionVertical, int positionHorizontal){
        super(name);
        this.positionVertical = positionVertical;
        this.positionHorizontal = positionHorizontal;

    }

    public void jumpDog(){
        if(positionVertical == 0 ){
            positionVertical = 4;
        } else{
            positionVertical = 0;
        }
        System.out.println("I'm jumping");
    }

    public void runDog(){
        if(positionHorizontal == 0 ){
            positionHorizontal = 4;
        } else{
            positionHorizontal = 0;
        }
        System.out.println("I'm running");
    }

    public void sayGav(){
        System.out.println("I say GAV GAV GAV");
    }
}
