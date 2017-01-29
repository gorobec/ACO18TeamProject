package week1.day2.animal_task;

/**
 * Created by anastasiia.shvetsova on 1/23/2017.
 */
public class Animal {
    private String name;

    public  Animal(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String showName(){
        return String.format("Animal name - %s", name);
    }
}
