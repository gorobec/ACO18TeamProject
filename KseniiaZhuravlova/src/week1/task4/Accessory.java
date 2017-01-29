package week1.task4;

/**
 * Created by ksyashka on 23.01.2017.
 */
public class Accessory extends Product {
    private String name;

    public Accessory(int cost, String name){
        super(cost);
        this.name = name;
    }

    @Override
    public String toString(){
       return String.format ("Accessory %s costs %d", name, getCost());
    }
}
