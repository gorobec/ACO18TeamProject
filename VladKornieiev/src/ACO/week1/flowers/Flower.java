package ACO.week1.flowers;

/**
 * Created by v21k on 24.01.17.
 */
public class Flower {
    private String name;
    private double price;
    private double length;
    private int freshnessLevel;

    public Flower(String name, double price, double length, int freshnessLevel) {
        this.name = name;
        this.price = price;
        this.length = length;
        this.freshnessLevel = freshnessLevel;
    }

    public static int compareTo(Flower f1, Flower f2) {
        return Integer.valueOf(f1.getFreshnessLevel()).compareTo(f2.getFreshnessLevel());
    }

    public double getPrice() {
        return price;
    }

    public double getLength() {
        return length;
    }

    public int getFreshnessLevel() {
        return freshnessLevel;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, price: %f, length: %f, freshness level (1-10): %d", name, price, length, freshnessLevel);
    }
}
