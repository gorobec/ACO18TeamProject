package week1.homeWork.klassMaterial.flower;

/**
 * Created by Игорь on 24.01.2017.
 */
public class Bouquet {
    private Flower[] flowers;
    private Accessory[] accessories;

    public Bouquet(Flower[] flowers, Accessory[] accessories) {
        this.flowers = flowers;
        this.accessories = accessories;
    }

    public Flower[] getFlowers() {
        return flowers;
    }

    public void setFlowers(Flower[] flowers) {
        this.flowers = flowers;
    }

    public int costBouquet(){
        int cost = 0;
        for (int i = 0; i < flowers.length; i++) {
            cost += flowers[i].getCost();
        }
        for (Accessory j: accessories) {
            cost += j.getCost();
        }
        return cost;
    }

    public static Flower[] sortByFreshness(Flower[] arr) {


        for (int j = 0; j < arr.length; j++) {

            for (int i = j + 1; i < arr.length; i++) {

                if (arr[i].getFreshness() < arr[j].getFreshness()) {
                    Flower temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }


        }
        return arr;
    }

    public static void findByStem(Bouquet bouquet, int start, int end){
        for (int i = 0; i < bouquet.flowers.length; i++) {
            if (bouquet.flowers[i].getLengthStem() >= start && bouquet.flowers[i].getLengthStem() <= end){
                System.out.println(bouquet.flowers[i].asSting());
            }
        }
    }

    public static void print(Bouquet bouquet){
        for (int i = 0; i < bouquet.flowers.length; i++) {
            System.out.println(bouquet.flowers[i].asSting());
        }
    }
}
