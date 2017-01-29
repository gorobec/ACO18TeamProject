package week1.day2.animal_task;

/**
 * Created by anastasiia.shvetsova on 1/23/2017.
 */
public class Run {
    public static void main(String arg[]){
        Puppy puppy = new Puppy(" Rocky", 0 , 0);

        System.out.println(puppy.showName());
        puppy.sayGav();
        puppy.jumpDog();
        puppy.runDog();
        puppy.bit();

    }
}
