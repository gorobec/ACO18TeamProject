package week1.homework.bouquet.flowers;

/**
 * Created by serhiim on 23-Jan-17.
 */
public class Flower {
    private String flowerName;
    private int freshness;
    private int stemLength;
    private double flowerPrice;

    public Flower() {
    }

    public Flower(String flowerName, int freshness, int stemLength, double flowerPrice) {
        this.flowerName = flowerName;
        this.freshness = freshness;
        this.stemLength = stemLength;
        this.flowerPrice = flowerPrice;
    }

    public String flowerToString(){
        return String.format("Flower name: %s, flower freshness: %d, flower stem length: %d, flower price: %f",
                flowerName, freshness, stemLength, flowerPrice);
    }


    public double getFlowerPrice() {
        return flowerPrice;
    }

    public int getFreshness() {
        return freshness;
    }

    public int getStemLength() {
        return stemLength;
    }
}
