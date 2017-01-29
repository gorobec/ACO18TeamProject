package ACO.week1.car;

/**
 * Created by v21k on 24.01.17.
 */
public class Wheel {
    private double diameter;
    private String model;

    public Wheel(double diameter, String model) {
        this.diameter = diameter;
        this.model = model;
    }

    public double getDiameter() {
        return diameter;
    }

    @Override
    public String toString() {
        return String.format("Wheel model: %s, diameter: %f", model, diameter);
    }
}
