package week1.homework.bouquet;

import week1.homework.bouquet.accessories.Accessories;
import week1.homework.bouquet.accessories.Basket;
import week1.homework.bouquet.accessories.Stripe;
import week1.homework.bouquet.accessories.WrappingMaterial;
import week1.homework.bouquet.flowers.Daisy;
import week1.homework.bouquet.flowers.Flower;
import week1.homework.bouquet.flowers.Rose;
import week1.homework.bouquet.flowers.Tulip;

/**
 * Created by serhiim on 24-Jan-17.
 */
public class MainBouquet {
    public static void main(String[] args) {
        Accessories stripe = new Stripe(10, "red", "stripe");
        Accessories basket = new Basket(50,"blue", "medium");
        Accessories wrap = new WrappingMaterial(15, "blue", "film");
        Accessories[] accessories = {stripe,basket,wrap};

        Flower rose = new Rose("rose", 3, 20, 25.5);
        Flower tulip = new Tulip("tulip", 3, 19, 20.5);
        Flower rose1 = new Daisy("daisy", 1, 23, 15);
        Flower rose2 = new Rose("rose", 2, 25, 20);
        Flower[] flowers = {rose, tulip, rose1, rose2};
        Bouquet bouquet = new Bouquet();
        bouquet.setAccessories(accessories);
        bouquet.setFlowers(flowers);

        System.out.println("******************");
        System.out.println("Print flowers in bouquet");
        System.out.println("******************");
        System.out.println(bouquet.bouquetToString());
        System.out.println();

        System.out.println("******************");
        System.out.println("Get bouquet price");
        System.out.println("******************");
        System.out.println("Bouquet price is: " + bouquet.getPrice());
        System.out.println(bouquet.getPrice());
        System.out.println();

        System.out.println("******************");
        System.out.println("Found flowers with stem length in range");
        System.out.println("******************");
        Bouquet flowersInRange = new Bouquet();
        flowersInRange.setFlowers(bouquet.findFlowersByStemRange(25, 20));
        System.out.println("Flowers with stem length in range 20 - 20: \n" + flowersInRange.bouquetToString());
        System.out.println();

        System.out.println("******************");
        System.out.println("Sort flowers by freshness");
        System.out.println("******************");
        bouquet.sortBouquetByFreshness();
        System.out.println(bouquet.bouquetToString());
    }
}
