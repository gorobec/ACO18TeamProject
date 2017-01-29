package week1.day2.car_task;

/**
 * Created by anastasiia.shvetsova on 1/23/2017.
 */
public class Run {
    public static void main(String arg[]) {
        Engine engine1 = new Engine(5600, 114, "rotary", true);
        Engine engine2 = new Engine(6600, 100, "petrol", true);
        Engine engine3 = new Engine(4600, 100, "petrol", false);

        Wheel wheel1 = new Wheel("black", 195);
        Wheel wheel2 = new Wheel("black", 195);
        Wheel wheel3 = new Wheel("black", 195);
        Wheel wheel4 = new Wheel("black", 195);

        Wheel[] wheels1 = {wheel1, wheel2, wheel3};
        Wheel[] wheels2 = {wheel1, wheel2, wheel3, wheel4};

        Car car1 = new Car(engine1, wheels1, "BMW", 0);
        Car car2 = new Car(engine2, wheels2, "Volvo", 0);
        Car car3 = new Car(engine3, wheels2, "Ford", 20);

        car1.go();
        car2.go();
        car2.setPetrol(20);
        car2.go();
        car3.go();
        car3.turnOnEngine();
        car3.go();

        System.out.println(car1.showCarModel());
    }
}
