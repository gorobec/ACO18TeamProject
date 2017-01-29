package week1.homeWork.klassMaterial.flower;

/**
 * Created by Игорь on 24.01.2017.
 */
public class RunFlower {
    public static void main(String[] args) {

        GardenFlower flower1 = new GardenFlower(20, 50, 10, "Rose");
        WildFlower flower2 = new WildFlower(15, 30, 8, "Lily");
        WildFlower flower3 = new WildFlower( 25, 65, 5, "Daisy");
        GardenFlower flower4 = new GardenFlower(20, 35, 3, "Tulip");
        GardenFlower flower5 = new GardenFlower(15, 60, 1, "Iris");
        Flower flower6 = new GardenFlower(25, 55, 2, "Tulip");
        Accessory accessory1 = new Accessory("ribbom", 10);
        Accessory accessory2 = new Accessory("pack", 15);
        Bouquet bouquet1 = new Bouquet(new Flower[]{flower1, flower2, flower3},
                                        new Accessory[]{accessory1, accessory2});
        Bouquet bouquet2 = new Bouquet(new Flower[]{flower6, flower4, flower5},
                                        new Accessory[]{accessory1, accessory2});

        System.out.println("Букет стоит - " + bouquet1.costBouquet() + " грн.");
        System.out.println();
        Bouquet.findByStem(bouquet2, 55, 60);
        bouquet1.setFlowers(Bouquet.sortByFreshness(bouquet1.getFlowers()));
        System.out.println();
        Bouquet.print(bouquet1);


    }
}
