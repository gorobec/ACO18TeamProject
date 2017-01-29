package ACO.week1.flowers;

/**
 * Created by v21k on 24.01.17.
 */
public class WildFlower extends Flower {

    private boolean isBush;

    public WildFlower(String name, double price, double length, int freshnessLevel, boolean isBush) {
        super(name, price, length, freshnessLevel);
        this.isBush = isBush;
    }
}
