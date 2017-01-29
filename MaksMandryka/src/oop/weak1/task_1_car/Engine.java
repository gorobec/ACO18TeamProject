package oop.weak1.task_1_car;

/**
 * Created by fmandryka on 24.01.2017.
 */
public class Engine {

    double capacity;
    String fuelType;
    double fuelConsumption;

    public Engine(double capacity, String fuelType, double fuelConsumption) {
        this.capacity = capacity;
        this.fuelType = fuelType;
        this.fuelConsumption = fuelConsumption;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getCapacity() {

        return capacity;
    }

    public String getFuelType() {
        return fuelType;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }
}
