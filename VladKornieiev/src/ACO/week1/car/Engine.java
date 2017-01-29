package ACO.week1.car;

/**
 * Created by v21k on 24.01.17.
 */
public class Engine {
    private double capacity;
    private String model;

    public Engine(double capacity, String model) {
        this.capacity = capacity;
        this.model = model;
    }

    @Override
    public String toString() {
        return String.format("model: %s, engine capacity: %f", model, capacity);
    }
}
