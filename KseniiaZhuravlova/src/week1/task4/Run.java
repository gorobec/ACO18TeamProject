package week1.task4;

/**
 * Created by ksyashka on 23.01.2017.
 */
public class Run {
    public static void main(String arg[]) {
        Accessory accessory1 = new Accessory(12, "paper");
        Accessory accessory2 = new Accessory(8, "tape");
        Flower rose = new Rose(20, 50);
        Flower chamomile1 = new Chamomile(10, 56);
        Flower chamomile2 = new Chamomile(10, 55);
        Flower chamomile3 = new Chamomile(10, 54);
        Flower lily = new Lily(15, 45);

        Accessory[] accessories = {accessory1, accessory2};
        Flower[] flowers = {rose, chamomile1, chamomile2, chamomile3, lily};

        Bouquet bouquet = new Bouquet(flowers, accessories);

        bouquet.showBouquetElements();
        System.out.println(bouquet.getCostBouquet());

        chamomile1.changeFreshness(2);
        rose.changeFreshness(3);
        System.out.println(bouquet.getCostBouquet());
        bouquet.sortFlowers();
        bouquet.showBouquetElements();
        bouquet.findFlower(53,57);
    }
}