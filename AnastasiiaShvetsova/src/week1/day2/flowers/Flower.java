package week1.day2.flowers;

/**
 * Created by Nastia on 23.01.17.
 */
public class Flower {
    private int lenghtStalk;
    private String name;
    private int price;
    private int freshnessLevel;

    public Flower(int lenghtStalk, String name, int price, int freshnessLevel){
        this.lenghtStalk = lenghtStalk;
        this.name = name;
        this.price = price;
        this.freshnessLevel = freshnessLevel;
    }

    public void showFlowerName(){
        System.out.println("Name of flower is " + name);
    }

    public int getLenghtStalk() {
        return lenghtStalk;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getFreshnessLevel() {
        return freshnessLevel;
    }
}
