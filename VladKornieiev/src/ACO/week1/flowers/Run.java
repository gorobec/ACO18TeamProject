package ACO.week1.flowers;

/**
 * Created by v21k on 24.01.17.
 */

public class Run {
    public static void main(String[] args) {
        // creating some flowers and accessories
        WildFlower wildFlower = new WildFlower("f1", 10, 5, 7, false);
        WildFlower wildFlower1 = new WildFlower("f1", 10, 5, 3, false);
        GardenFlower gardenFlower = new GardenFlower("f2", 15, 12, 9, "Summer");
        GardenFlower gardenFlower2 = new GardenFlower("f2", 15, 12, 5, "Summer");
        Accessory accessory1 = new Accessory("some accessory 1", 12);
        Accessory accessory2 = new Accessory("some accessory 2", 15);

        Flower[] flowers = {wildFlower, gardenFlower, wildFlower1, gardenFlower2};
        Accessory[] accessories = {accessory2, accessory1};

        Bouquet bouquet = new Bouquet();
        bouquet.makeBouquet(flowers, accessories);

        System.out.println("Price: " + bouquet.getPrice());

        System.out.println();

        bouquet.printBouquet();
        System.out.println();

        bouquet.sortBouquet();

        bouquet.printBouquet();
        System.out.println();

        bouquet.findByLength(2, 9);
        bouquet.findByLength(15, 19);
    }
}
