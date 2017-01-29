package task1;

/**
 * Created by Sherlock on 26.01.2017.
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

        Engine engine = new Engine(2.0, "23xM");

        Car car = new Car("Seat Ibiza", wheels, engine, 100, 44);
// test

        System.out.println(car.toString());

        car.showModel();
        car.startDriving(100);

        System.out.println();

        car.refuel(10);

        System.out.println();

        Wheel wheel5 = new Wheel(4);
        Wheel wheel6 = new Wheel(4);

        car.replaceWheel(wheel1, 1);
        car.replaceWheel(wheel6, 3);


    }
}
