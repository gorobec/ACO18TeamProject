package week1.task1;

/**
 * Created by ksyashka on 23.01.2017.
 */
public class Run {
    public static void main(String arg[]) {
        Car car = new Car("BMW", 4, 19, 400, 80);

        car.showModel();
        car.go();
        car.refuel(60);
        car.go();
        car.breakWheel(2);
        car.go();
        car.changeWheels(19, 2);
        car.go();
    }
}
