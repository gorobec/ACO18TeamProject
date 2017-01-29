package oop.weak1.task_4_florist;

/**
 * Created by Администратор on 24.01.2017.
 */
public class Bouquet {

    private Flower[] flowerSet;
    private Accessories[] accessories;

    public Bouquet(Flower[] flowerSet, Accessories[] accessories) {
        this.flowerSet = flowerSet;
        this.accessories = accessories;
    }

    public void setFlowerSet(Flower[] flowerSet) {
        this.flowerSet = flowerSet;
    }

    public void setAccessories(Accessories[] accessories) {
        this.accessories = accessories;
    }

    public Flower[] getFlowerSet() {
        return flowerSet;
    }

    public Accessories[] getAccessories() {
        return accessories;
    }

    public void sortFlowersByFreshness() {

        if (flowerSet != null) {

            Flower buffer;
            for (int i = 0; i < flowerSet.length - 1; i++) {
                for (int j = i + 1; j < flowerSet.length; j++) {
                    if (flowerSet[i] != null && flowerSet[i].compareTo(flowerSet[j]) < 0) {

                        buffer = flowerSet[i];
                        flowerSet[i] = flowerSet[j];
                        flowerSet[j] = buffer;

                    }
                }
            }
        }

    }

    public Flower[] findFlowersByStemLength(int from, int to) {

        Flower[] flowers = new Flower[0];

        if (flowerSet != null) {

            for (int i = 0; i < flowerSet.length; i++) {
                if (flowerSet[i] != null && (flowerSet[i].getStemLengh() >= from & flowerSet[i].getStemLengh() <= to)) {
                    flowers = ArrayUtils.addElement(flowers, flowerSet[i]);
                }
            }
        }

        return flowers;
    }

    public float value() {

        float value = 0;

        if (flowerSet != null) {
            for (Flower fl : flowerSet) {
                if (fl != null) value += fl.getCost();
            }
        }

        if (accessories != null) {
            for (Accessories ac : accessories) {
                if (ac != null) value += ac.getPrice();
            }
        }

        return value;
    }
}
