package week1.task1;

/**
 * Created by ksyashka on 23.01.2017.
 */
public class Car {
    private String model;
    private Wheel[] wheels;
    private Engine engine;
    private int volumeTank;
    private int fuel;

    public Car(String model, int numWheels, int diam, int hp, int volumeTank) {
        this.model = model;
        this.wheels = new Wheel[numWheels];
        for (int i = 0; i < wheels.length; i++)
            this.wheels[i] = new Wheel(diam, true);
        this.engine = new Engine(hp, true);
        this.volumeTank = volumeTank;
    }

    public void go() {
        if (!engine.checkEngine())
            System.out.println("Fix engine!");
        else if (!checkWheels())
            System.out.println("Change wheel!");
        else if (fuel == 0) System.out.println("Refuel!");
        else System.out.println("Going!");
    }

    public boolean checkWheels() {
        boolean result = true;
        for (int i = 0; i < wheels.length; i++)
            if (!wheels[i].checkWheel()) {
                System.out.println("Wheel " + i + " is not ok!");
                result = false;
            }
        return result;
    }

    public boolean refuel(int fuel) {
        if (fuel <= 0) {
            System.out.println("You need fuel!");
            return false;
        }
        if ((this.fuel += fuel) > volumeTank) {
            System.out.println("Too much fuel!");
            return false;
        }
        this.fuel += fuel;
        return true;
    }

    public boolean changeWheels(int diam, int index) {
        if (index < 0 || index > wheels.length) {
            System.out.println("Error changing wheel!");
            return false;
        }
        return wheels[index].changeWheel(diam);
    }

    public boolean breakWheel(int index) {
        if (index < 0 || index > wheels.length) {
            System.out.println("Wheel does not exist!");
            return false;
        }
        wheels[index].breakWheel();
        return true;
    }

    public void showModel() {
        System.out.println("Car model is " + model);
    }


}
