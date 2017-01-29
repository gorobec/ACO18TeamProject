package task1;

/**
 * Created by Sherlock on 26.01.2017.
 */
public class Wheel {
    private int wheelDiameters;

    public Wheel(int wheelDiameters) {
        this.wheelDiameters = wheelDiameters;
    }

    public double getWheelDiameters() {
        return wheelDiameters;
    }


    @Override
    public String toString() {
        return String.format("Diameter: %f", wheelDiameters);
    }

}

