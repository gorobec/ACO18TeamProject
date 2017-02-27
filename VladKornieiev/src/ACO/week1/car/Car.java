package ACO.week1.car;

import java.util.Scanner;

/**
 * Created by v21k on 24.01.17.
 */
public class Car {
    private String model;
    private int year;
    private Wheel[] wheels;
    private Engine engine;
    private double fuel;

    public Car(String model, int year, Wheel[] wheels, Engine engine, double fuel) {
        this.model = model;
        this.year = year;
        this.wheels = wheels;
        this.engine = engine;
        this.fuel = fuel;
    }

    @Override
    public String toString() {
        return String.format("Car com.bestBuy.model: %s,\nyear: %d,\nengine %s,\nfuel: %f",
                model, year, engine.toString(), fuel);
    }

    public void printModel() {
        System.out.println("Model: " + model);
    }

    public void drive(double distance) {
        if (fuel >= distance / 10) {
            fuel -= distance / 10;
            System.out.printf("I'm driving. Fuel level after driving: %f\n", fuel);
        } else {
            System.out.println("No fuel!");
        }
    }

    public void refuel(double fuel) {
        this.fuel += fuel;
        System.out.printf("OK! Fueled %f liters. You have %f litres now.\n", fuel, this.fuel);
    }

    public void replaceWheel(Wheel wheel) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Which wheel has com.bestBuy.to be replaced?");
        System.out.println("1-2 for right/left front wheel, 3-4 for right/left rear wheel");
        int wheelIndex = sc.nextInt();

        // validation
        if (wheelIndex >= 1 && wheelIndex <= 4 && wheel.getDiameter() == wheels[0].getDiameter()) {
            wheels[wheelIndex - 1] = wheel;
            System.out.println("Done! Your wheels now:");
            // print all wheels
            for (Wheel wh : wheels) {
                System.out.println(wh.toString());
            }
        } else if (wheelIndex < 1 || wheelIndex > 4) {
            System.out.println("Wrong index.");
        } else if (wheel.getDiameter() != wheels[0].getDiameter()) {
            System.out.println("Wrong diameter.");
        }
    }

}
