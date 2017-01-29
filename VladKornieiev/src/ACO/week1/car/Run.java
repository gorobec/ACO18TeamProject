package ACO.week1.car;

/**
 * Created by v21k on 24.01.17.
 */
public class Run {
    public static void main(String[] args) {
        // wheels and engine for our car
        Wheel wh = new Wheel(19, "Goodyear");
        Wheel[] wheels = {wh, wh, wh, wh};
        Engine engine = new Engine(2.0, "M34iK");

        Car car = new Car("Alfa Romeo", 2010, wheels, engine, 100);

        // test
        System.out.println(car.toString());

        System.out.println();

        car.printModel();
        car.drive(100);
        car.refuel(32);

        System.out.println();

        // replacing test
        Wheel anotherWheel1 = new Wheel(19, "Michelin");
        car.replaceWheel(anotherWheel1);

        System.out.println();

        Wheel anotherWheel2 = new Wheel(20, "Rosava");
        car.replaceWheel(anotherWheel2);
    }
}
