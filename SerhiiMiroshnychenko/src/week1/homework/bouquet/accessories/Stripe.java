package week1.homework.bouquet.accessories;

/**
 * Created by serhiim on 24-Jan-17.
 */
public class Stripe extends Accessories{
    private String type; // stripe, cord

    public Stripe(double price, String color, String type) {
        super(price, color);
        this.type = type;
    }
}
