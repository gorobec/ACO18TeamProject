package week1.homeWork.klassMaterial.flower;

/**
 * Created by Игорь on 24.01.2017.
 */
public class GardenFlower extends Flower{
    private String name;

    public GardenFlower(int cost, int lenghtStem, int freshness, String name) {
        super(cost, lenghtStem, freshness);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
