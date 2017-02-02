package week1.task1;

public class TestCar {
    public static void main(String[] args) {
        Engine engine = new Engine();
        Wheel wheels = new Wheel();
        Car car = new Car("BMW", 15, engine, wheels, false, true);

        System.out.println(car.ride());
        System.out.println(car.refuel());
        System.out.println(car.replaceWheel());
        System.out.println(car.showCarModel());
    }
}
