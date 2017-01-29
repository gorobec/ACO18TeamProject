package ACO.week1.flowers;

/**
 * Created by v21k on 24.01.17.
 */
public class Accessory {
    private String name;
    private double price;

    public Accessory(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, price: %f", name, price);
    }
}
