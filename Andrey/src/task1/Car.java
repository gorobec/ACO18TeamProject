package task1;

/**
 * Created by Sherlock on 26.01.2017.
 */
public class Car {
    private String model;
    private Wheel[] wheels;
    private Engine engine;
    private double fuelVolumeInTank;       //об"єм бака
    private double fuel;
    private int wheelsDiameters;
    private double capacity;
    private double fuelConsumption;//об"єм двигуна


    public Car(String model, Wheel[] wheels, Engine engine, int fuel, int wheelsDiameters) {
        this.model = model;
        this.wheels = wheels;
        this.engine = engine;
        this.fuel = fuel;
        this.wheelsDiameters = wheelsDiameters;
    }

    public double getFuelVolumeInTank() {
        return fuelVolumeInTank;
    }

    public Wheel[] getWheels() {
        return wheels;
    }

    public void setWheels(Wheel[] wheels) {
        this.wheels = wheels;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;

    }


    public void showModel() {
        System.out.println( model);
    }

   @Override
    public String toString() {
        return String.format("Car com.bestBuy.model: %s,\nengine %s, ",
                 model, engine.toString());
    }


    public double startDriving(double distance) {

        if (fuel > distance * fuelConsumption / 100) {
            System.out.printf("Достатньо бензину ", distance);
            fuel -= distance * fuelConsumption / 100;

        } else {
            distance = fuel * 100 / fuelConsumption;
            System.out.println("Cкоріше їдь на заправку!!!");
            fuel = 0;
        }
        return distance;
    }


    public double refuel(double fuelVolume) {
        if (fuel > getFuelVolumeInTank()) {
            System.out.printf("Бак переповнений", (fuel - getFuelVolumeInTank()));
            fuel = getFuelVolumeInTank();
        } else {
            System.out.printf("Заправлено  - ", fuelVolume);
        }
        return fuel;
    }


    public Wheel[] replaceWheel(Wheel newWheel, int position) {

        Wheel[] wheels = getWheels();
        if (wheelsDiameters == newWheel.getWheelDiameters()) {
            wheels[position] = newWheel;
            System.out.printf("Колесо %d успешно заменили\n", position);
        } else {
            System.out.printf("Колесо %d невозможно заменить, не совпадает диаметр\n", position);
        }

        return wheels;
    }

}
