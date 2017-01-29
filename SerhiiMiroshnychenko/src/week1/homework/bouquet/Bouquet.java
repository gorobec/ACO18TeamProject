package week1.homework.bouquet;

import week1.homework.bouquet.accessories.Accessories;
import week1.homework.bouquet.flowers.Flower;

/**
 * Created by serhiim on 24-Jan-17.
 */
public class Bouquet {
    private double price;
    private Flower[] flowers;
    private Accessories[] accessories;



    public void setAccessories(Accessories[] accessories) {
        this.accessories = accessories;
    }

    public void setFlowers(Flower[] flowers) {
        this.flowers = flowers;
    }

    public double getPrice() {
        countBouquetPrice();
        return price;
    }

    public void countBouquetPrice() {
        price = 0;
        for (int i = 0; i < accessories.length; i++) {
            price += accessories[i].getPrice();
        }

        for (int i = 0; i < flowers.length; i++) {
            price += flowers[i].getFlowerPrice();

        }
    }

    public void sortBouquetByFreshness(){
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < flowers.length -1; i++) {
                if (flowers[i].getFreshness() > flowers[i + 1].getFreshness()) {
                    Flower temp = flowers[i];
                    flowers[i] = flowers[i + 1];
                    flowers[i + 1] = temp;
                    flag = true;
                }
            }
        }
    }

    public Flower[] findFlowersByStemRange(int max, int min){
        Flower[] temp = new Flower[flowers.length];
        int count = 0;
        for (int i = 0; i < flowers.length; i++) {
            if (flowers[i] == null){
                continue;
            }
            if (flowers[i].getStemLength() >= min && flowers[i].getStemLength() <= max){
                temp[count] = flowers[i];
                count++;
            }
        }
        Flower[] flowersInRange = new Flower[count];
        System.arraycopy(temp, 0, flowersInRange, 0, count);
        return flowersInRange;
    }

    public String bouquetToString(){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < flowers.length; i++) {
            if (flowers[i] == null){
                continue;
            }
            builder.append(flowers[i].flowerToString());
            builder.append("\n");
        }
        return builder.toString();
    }
}
