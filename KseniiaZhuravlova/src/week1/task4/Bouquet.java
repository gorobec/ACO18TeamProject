package week1.task4;
import java.util.*;

/**
 * Created by ksyashka on 23.01.2017.
 */
public class Bouquet {
    Flower[] flowers;
    Accessory[] accessories;

    public Bouquet(Flower[] flowers, Accessory[] accessories) {

        this.flowers = flowers;
        this.accessories = accessories;
    }

    public int getCostBouquet() {
        int cost = 0;
        for (int i = 0; i < flowers.length; i++)
            cost += flowers[i].getCost();
        for (int i = 0; i < accessories.length; i++)
            cost += accessories[i].getCost();

        return cost;
    }

    public void showBouquetElements() {
        for (int i = 0; i < flowers.length; i++)
            System.out.println(flowers[i].toString());
        for (int i = 0; i < accessories.length; i++)
            System.out.println(accessories[i].toString());
    }

    public void sortFlowers() {
        Flower temp;
        for (int i = flowers.length - 1; i > 0; i--)
            for (int j = 0; j < i; j++)
                if (flowers[j].compareTo(flowers[j + 1]) > 0) {
                    temp = flowers[j];
                    flowers[j] = flowers[j + 1];
                    flowers[j + 1] = temp;
                }

    }

    public void findFlower(int minStemLen, int maxStemLen){
        System.out.format("Flowers with stem in [%d ; %d]:%n", minStemLen, maxStemLen);
        for (int i=0;i<flowers.length;i++){
            if(flowers[i].stemLengthInRange(minStemLen,maxStemLen))
                System.out.println(flowers[i].toString());

        }
    }
}
