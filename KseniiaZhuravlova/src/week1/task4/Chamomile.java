package week1.task4;

/**
 * Created by ksyashka on 23.01.2017.
 */
public class Chamomile extends Flower {
    public Chamomile(int cost, int stemLength) {
        super(cost, stemLength);
    }

    @Override
    public String toString() {
        return "Chamomile: " + super.toString();
    }
}
