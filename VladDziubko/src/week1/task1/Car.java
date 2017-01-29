package week1.task1;

public class Car {
    private String carModel;
    private int fuelLevel;
    private Engine engine;
    private Wheel wheels;
    private boolean puncturedTire;
    private boolean engineIsOk;

    public Car(String carModel, int fuelLevel, Engine engine, Wheel wheels, boolean puncturedTire, boolean engineIsOk) {
        this.carModel = carModel;
        this.fuelLevel = fuelLevel;
        this.engine = engine;
        this.wheels = wheels;
        this.puncturedTire = puncturedTire;
        this.engineIsOk = engineIsOk;
    }

    public Car() {
    }

    public void setWheels(Wheel wheels) {
        this.wheels = wheels;
    }

    public Wheel getWheels() {
        return wheels;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Engine getEngine() {
        return engine;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(int fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public boolean isPuncturedTire() {
        return puncturedTire;
    }

    public void setPuncturedTire(boolean puncturedTire) {
        this.puncturedTire = puncturedTire;
    }

    public boolean isEngineIsOk() {
        return engineIsOk;
    }

    public void setEngineIsOk(boolean engineIsOk) {
        this.engineIsOk = engineIsOk;
    }

    public String showCarModel() {
        return String.format("Car model is -> %s", carModel);
    }

    public StringBuilder ride() {
        if (!engineIsOk) {
            return engine.stop();
        }
        return new StringBuilder("Have a nice ride!");
    }

    public StringBuilder refuel() {
        if (fuelLevel < 10) {
            return new StringBuilder("Low fuel level! Find the nearest gas station!");
        }
        return new StringBuilder("Sufficient level of gas!");
    }

    public StringBuilder replaceWheel() {
        if (puncturedTire == true) {
            return wheels.wheelReplace();
        }
        return new StringBuilder("Don`t need to replace wheels. Ride safely.");
    }
}
