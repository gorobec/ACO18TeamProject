package week1.homework.automobile;

/**
 * Created by serhiim on 23-Jan-17.
 */
public class MainCar {
    public static void main(String[] args) {

        Wheel wheel1Car1 = new Wheel();
        Wheel wheel2Car1 = new Wheel();
        Wheel wheel3Car1 = new Wheel();
        Wheel wheel4Car1 = new Wheel();
        Wheel[] wheels = {wheel1Car1,wheel2Car1,wheel3Car1,wheel4Car1};
        Engine engine = new Engine();
        Car car1 = new Car("BMW", engine, wheels, 100);
        car1.printModel();
        System.out.println();

        car1.setSpareWhell(new Wheel());
        car1.startDriving();
        System.out.println();

        System.out.println();

        System.out.println("**************************");
        System.out.println("No fuel");
        System.out.println("**************************");
        System.out.println();

        car1.setFuelLevel(9);
        car1.startDriving();
        car1.fillingUp();
        car1.startDriving();

        System.out.println("**************************");
        System.out.println("Break one wheel");
        System.out.println("**************************");
        System.out.println();

        car1.getWheels()[1].setIsBroken(true);
        car1.startDriving();
        System.out.println();

        System.out.println("**************************");
        System.out.println("Break one wheel and spare wheel");
        System.out.println("**************************");
        System.out.println();

        car1.getSpareWhell().setIsBroken(true);
        car1.getWheels()[1].setIsBroken(true);
        car1.startDriving();




    }
}
