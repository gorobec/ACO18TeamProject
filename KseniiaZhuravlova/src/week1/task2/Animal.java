package week1.task2;

/**
 * Created by ksyashka on 23.01.2017.
 */
public class Animal {
    private String name;

    public Animal(String name){
        this.name = name;
    }

    public void showName(){
        System.out.println("My name is " + name);
    }

    @Override
    public String toString(){
        return name;
    }
}
