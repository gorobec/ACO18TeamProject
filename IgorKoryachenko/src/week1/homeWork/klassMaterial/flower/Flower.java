package week1.homeWork.klassMaterial.flower;

/**
 * Created by Игорь on 24.01.2017.
 */
public class Flower {

    private int cost;
    private int lengthStem;
    private int freshness;

    public Flower(int cost, int lenghtStem, int freshness) {
        this.cost = cost;
        this.lengthStem = lenghtStem;
        this.freshness = freshness;
    }

    public int getCost() {
        return cost;
    }

    public int getLengthStem() {
        return lengthStem;
    }

    public int getFreshness() {
        return freshness;
    }

    public  String asSting() {
        return String.format("cost - %d, ltngthStem - %d, freshness - %d", cost, lengthStem, freshness);
    }
}
