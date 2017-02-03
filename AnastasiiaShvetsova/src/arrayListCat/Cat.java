package arrayListCat;

import java.util.ArrayList;

/**
 * Created by anastasiia.shvetsova on 2/3/2017.
 */
public class Cat {
    public static ArrayList<Cat> cats ;
    private String name;

    public Cat(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Car's name " + name;
    }
}
