package week1.task4;

/**
 * Created by ksyashka on 23.01.2017.
 */
public class Flower extends Product {
    private int freshness;
    private int stemLength;

    public Flower(int cost, int stemLength) {
        super(cost);
        this.freshness = 1;
        this.stemLength = stemLength;
    }

    public int compareTo(Flower flower) {
        if (this.freshness > flower.freshness) return 1;
        if (this.freshness < flower.freshness) return -1;
        return 0;
    }

    public boolean stemLengthInRange(int minStemLen, int maxStemLen) {
        if (this.stemLength >= minStemLen && this.stemLength <= maxStemLen) return true;
        return false;
    }

    @Override
    public String toString() {
        return String.format("Price - %d UAH, freshness - %d days, stemLength - %d cm", getCost(), freshness, stemLength);
    }

    public boolean changeFreshness(int days) {
        freshness += days;
        setCost(getCost() - days * 2);
        if (getCost() < 0) {
            System.out.println("Flower is spoiled!");
            return false;
        }
        return true;
    }


}
