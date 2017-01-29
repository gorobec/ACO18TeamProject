package week1.homework.automobile.test;

import week1.homework.automobile.Car;
import week1.homework.automobile.Engine;
import week1.homework.automobile.Wheel;

/**
 * Created by serhiim on 23-Jan-17.
 */
public class TestCar {

    public static void main(String[] args) {
        testfillingUp();
        testChangeWheel();

    }

    private static void testfillingUp(){
        Car car = new Car("BMW", new Engine(), new Wheel[4], 0);
        car.fillingUp();
        assert car.getFuelLevel() == 100:"Fuel is not 100";

    }

    private static  void testChangeWheel(){
        Wheel wheel1Car1 = new Wheel();
        Wheel wheel2Car1 = new Wheel();
        Wheel wheel3Car1 = new Wheel();
        Wheel wheel4Car1 = new Wheel();
        Wheel[] wheels = {wheel1Car1,wheel2Car1,wheel3Car1,wheel4Car1};
        Engine engine = new Engine();
        Car car1 = new Car("BMW", engine, wheels, 100);
        car1.setSpareWhell(new Wheel());
        car1.getWheels()[1].setIsBroken(true);

        assert car1.getWheels()[1].getIsBroken():"Wheel is not broken";

        car1.changeWheel(car1.getSpareWhell());

        for (int i = 0; i <car1.getWheels().length ; i++) {
            assert !car1.getWheels()[i].getIsBroken():"One wheel is broken.";

        }
    }
}
