package week1.homework.bouquet.accessories;

/**
 * Created by serhiim on 24-Jan-17.
 */
public class WrappingMaterial extends Accessories{
    private String type; //organza, film, paper

    public WrappingMaterial(double price, String color, String type) {
        super(price, color);
        this.type = type;
    }
}
