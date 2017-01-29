package week1.task4;

/**
 * Created by ksyashka on 23.01.2017.
 */
public class Lily extends Flower {
    public Lily(int cost, int stemLength) {
        super(cost, stemLength);
    }

    @Override
    public String toString() {
        return "Lily: " + super.toString();
    }
}