package oop.weak1.task_1_car;

/**
 * Created by fmandryka on 24.01.2017.
 */
public class Run {

    public static void main(String[] args) {

        Wheel wheel1 = new Wheel(14);
        Wheel wheel2 = new Wheel(14);
        Wheel wheel3 = new Wheel(14);
        Wheel wheel4 = new Wheel(14);

        Wheel[] wheels = new Wheel[4];

        wheels[0] = wheel1;
        wheels[1] = wheel2;
        wheels[2] = wheel3;
        wheels[3] = wheel4;

        Engine engine = new Engine(1.4, "petrol", 10.1);

        Car car = new Car(wheels, engine, "Shevrolet Aveo", 50, 14);

        car.refuel(70, "petrol");

        car.drive(287);

        Wheel wheel5 = new Wheel(14);
        Wheel wheel6 = new Wheel(15);
        car.replaceWheel(wheel5, 0);
        car.replaceWheel(wheel6, 3);

        car.showModel();

        car.refuel(10, "petrol");
        car.refuel(5, "diesel");

        car.drive(400);
    }
}
