package ACO.week1.flowers;

/**
 * Created by v21k on 24.01.17.
 */
public class GardenFlower extends Flower {

    private String floweringSeason;

    public GardenFlower(String name, double price, double length, int freshnessLevel, String floweringSeason) {
        super(name, price, length, freshnessLevel);
        this.floweringSeason = floweringSeason;
    }
}
