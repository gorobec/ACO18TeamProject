package week1.day2.flowers;

/**
 * Created by Nastia on 23.01.17.
 */
public class Run {
    public static void main(String arg[]){
        Flower rose1 = new Rose(15, "Rose", 100, 2);
        Flower rose2 = new Rose(15, "Rose", 100, 2);
        Flower tulip = new Tulip(16, "Tulip", 80,  5);
        Flower lily1 = new Lily(18, "Lily", 200, 4);
        Flower lily2 = new Lily(20, "Lily", 180, 3);

        Flower[] flowers = {rose1, rose2, tulip, lily1, lily2};

        Bouquet bouquet = new Bouquet(flowers);
        bouquet.showFlowers();

        bouquet.printPrice();
        System.out.println();
        bouquet.sortFlowersByFreshness();
        bouquet.showFlowers();
        //bouquet.findFlower(15);
    }
}
