package ACO.week1.flowers;

import java.util.Arrays;

/**
 * Created by v21k on 24.01.17.
 */
public class Bouquet {
    private Flower[] flowers;
    private Accessory[] accessories;

    // empty constructor if we want to make a bouquet later
    public Bouquet() {
    }

    public Bouquet(Flower[] flowers, Accessory[] accessories) {
        this.flowers = flowers;
        this.accessories = accessories;
    }

    public void makeBouquet(Flower[] flowers, Accessory[] accessories) {
        this.flowers = flowers;
        this.accessories = accessories;
    }

    // if we don't have accessories
    public void makeBouquet(Flower[] flowers) {
        this.flowers = flowers;
    }

    public void sortBouquet() {
        Arrays.sort(flowers, Flower::compareTo);
    }

    public double getPrice() {
        double sum = 0;
        if (flowers.length >= 1) {
            for (Flower flower : flowers) {
                sum += flower.getPrice();
            }
        }
        if (accessories.length >= 1) {
            for (Accessory accessory : accessories) {
                sum += accessory.getPrice();
            }
        }
        return sum;
    }

    public void findByLength(int start, int end) {
        if (flowers.length >= 1) {
            for (int i = 0; i < flowers.length; i++) {
                if (flowers[i].getLength() >= start && flowers[i].getLength() <= end) {
                    System.out.println("Position: " + i + " " + flowers[i].toString());
                }
            }
        } else {
            System.out.println("Bouquet is empty");
        }
    }

    public void printBouquet() {
        // print flowers
        if (flowers.length >= 1) {
            System.out.println("Bouquet flowers:");
            for (Flower fl : flowers) {
                System.out.println(fl.toString());
            }
        } else {
            System.out.println("No flowers in bouquet.");
        }

        // print accessories
        if (accessories.length >= 1) {
            System.out.println("Bouquet accessories:");
            for (Accessory acc : accessories) {
                System.out.println(acc.toString());
            }
        } else {
            System.out.println("No accessories in bouquet.");
        }
    }
}
