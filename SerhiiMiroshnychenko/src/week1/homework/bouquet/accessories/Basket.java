package week1.homework.bouquet.accessories;

/**
 * Created by serhiim on 24-Jan-17.
 */
public class Basket extends Accessories {
    private String size;

    public Basket(double price, String color, String size) {
        super(price, color);
        this.size = size;
    }
}
