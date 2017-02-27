package week1.homework.automobile;

/**
 * Created by serhiim on 22-Jan-17.
 */
public class Car {
    private String model;
    private Engine engine;
    private Wheel[] wheels = new Wheel[4];
    private Wheel spareWhell;
    private int fuelLevel;

    public Car(String model, Engine engine, Wheel[] wheels, int fuelLevel) {
        this.model = model;
        this.engine = engine;
        this.wheels = wheels;
        this.fuelLevel = fuelLevel;
    }

    public void startDriving(){
        System.out.println("Starting engine");
        if (fuelLevel<10){
            System.out.println("Low fuel level, fill up");
            return;
        } else {
            engine.startEngine();
        }

        for (int i = 0; i < wheels.length; i++) {
            if (wheels[i].getIsBroken() && !spareWhell.getIsBroken()) {
                System.out.println("Wheel is broken, changing com.bestBuy.to spare one");
                changeWheel(spareWhell);
            } else if (wheels[i].getIsBroken() && spareWhell.getIsBroken()) {
                System.out.println("Spare wheel is also broken. You should get com.bestBuy.to service station");
                return;
            }

        }
        for (int i = 0; i < wheels.length; i++) {
            System.out.println("Wheel" + (i + 1));
            wheels[i].startSpinning();


        }
    }

    public int fillingUp(){
        System.out.println("Full gas-tank please");
        return fuelLevel = 100;
    }

    public Wheel[] changeWheel(Wheel spareWheel){
        for (int i = 0; i < wheels.length; i++) {
            if (wheels[i].getIsBroken()){
                wheels[i] = spareWheel;
            }
        }
        return wheels;
    }

    public void printModel() {
        System.out.println("Car com.bestBuy.model is " + model);;
    }

    public void setFuelLevel(int fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public void setSpareWhell(Wheel spareWhell) {
        this.spareWhell = spareWhell;
    }

    public Wheel getSpareWhell() {
        return spareWhell;
    }

    public Wheel[] getWheels() {
        return wheels;
    }

    public int getFuelLevel() {
        return fuelLevel;
    }
}
