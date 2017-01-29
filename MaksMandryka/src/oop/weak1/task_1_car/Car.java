package oop.weak1.task_1_car;

/**
 * Created by fmandryka on 24.01.2017.
 */
public class Car {

    private Wheel[] wheels;
    private Engine engine;
    private String model;
    private int maxFuelTankVolume;
    private double fuelVolumeInTank;
    private int wheelsDiameter;

    public Car(Wheel[] wheels, Engine engine, String model, int maxFuelTankVolume, int wheelsDiameter) {
        this.wheels = wheels;
        this.engine = engine;
        this.model = model;
        this.maxFuelTankVolume = maxFuelTankVolume;
        this.wheelsDiameter = wheelsDiameter;
    }

    public Wheel[] getWheels() {
        return wheels;
    }

    public void setWheels(Wheel[] wheels) {
        this.wheels = wheels;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {

        return engine;
    }

    public String getModel() {
        return model;
    }

    public double drive(double distance) {

        if (fuelVolumeInTank >= distance * getEngine().getFuelConsumption() / 100) {
            System.out.printf("Проехано расстояние %f км\n", distance);
            fuelVolumeInTank -= distance * getEngine().getFuelConsumption() / 100;

        } else {
            distance = fuelVolumeInTank * 100 / getEngine().getFuelConsumption();
            System.out.printf("Проехано расстояние %f км, закончилось топливо\n", distance);
            fuelVolumeInTank = 0;
        }

        return distance;
    }

    public Wheel[] replaceWheel(Wheel newWheel, int position) {

        Wheel[] wheels = getWheels();
        if (wheelsDiameter == newWheel.getDiameter()) {
            wheels[position] = newWheel;
            System.out.printf("Колесо %d успешно заменили\n", position);
        } else {
            System.out.printf("Колесо %d невозможно заменить, не совпадает диаметр\n", position);
        }

        return wheels;
    }

    public double refuel(double fuelVolume, String fuelType) {

        if (engine.getFuelType() == fuelType) {
            fuelVolumeInTank += fuelVolume;
        } else {
            System.out.println("В баке " + fuelVolumeInTank + "л, заправка не удалась, несовпадает тип топлива");
            return fuelVolumeInTank;
        }

        if (fuelVolumeInTank > maxFuelTankVolume) {
            System.out.println("Заправлен полный бак, не влезло в бак " + (fuelVolumeInTank - maxFuelTankVolume) + " л.");
            fuelVolumeInTank = maxFuelTankVolume;
        } else {
            System.out.println("В баке " + fuelVolumeInTank + "л, было заправлено " + fuelVolume + "л.");
        }

        return fuelVolumeInTank;
    }

    public void showModel() {
        System.out.println(model);
    }

}
