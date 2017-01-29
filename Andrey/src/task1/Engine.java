package task1;

/**
 * Created by Sherlock on 26.01.2017.
 */
public class Engine {
    //  private String fuelType;
    private double capacity; //об"єм
    private String model;


    public Engine( double capacity, String model) {
        this.capacity = capacity;
        this.model = model;
    }

    @Override
    public String toString() {
        return String.format("model: %s, engine capacity: %f", model, capacity);
    }

}
