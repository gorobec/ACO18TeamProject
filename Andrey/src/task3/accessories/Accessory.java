package task3.accessories;

import task3.flowers.Flowers;

import java.util.ArrayList;

/**
 * Created by Sherlock on 27.01.2017.
 */
public class Accessory {

    int accessoryPrice;
    private ArrayList<Flowers> flowerses;


    public Accessory(ArrayList<Flowers> flowers) {
        this.flowerses = flowers;
    }


    public int getAccessoryPrice() {
        return accessoryPrice;
    }

    public void setAccessoryPrice(int accessoryPrice) {
        this.accessoryPrice = accessoryPrice;
    }

    public int totalPrise() {
        int totalPrise = 0;
        for (Flowers flowers : flowerses) {
            totalPrise += flowers.getPrice();
        }
        totalPrise += getAccessoryPrice();
        return totalPrise;
    }


    public ArrayList<Flowers> findFlowers(int minStemLength, int maxStemLength) {

        ArrayList<Flowers> foundFlowers = new ArrayList<Flowers>();


        for (Flowers flower : flowerses) {
            if (flower.getSremLength() > minStemLength && flower.getSremLength() < maxStemLength) {
                foundFlowers.add(flower);
            }
        }

        return foundFlowers;
    }

    public ArrayList<Flowers> findFlowers2(int minFreshness, int maxFreshness) {

        ArrayList<Flowers> foundFlowers2 = new ArrayList<Flowers>();

        for (Flowers flower : flowerses) {
            if (flower.getFreshnes() > minFreshness && flower.getFreshnes() < maxFreshness) {
                foundFlowers2.add(flower);
            }
        }

        return foundFlowers2;
    }

}
