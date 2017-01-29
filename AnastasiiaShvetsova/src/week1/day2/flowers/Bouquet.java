package week1.day2.flowers;

/**
 * Created by Nastia on 23.01.17.
 */
public class Bouquet{
    private Flower[] flowers;

    public Bouquet(Flower[] flowers){
        this.flowers = flowers;
    }

    public void printPrice(){
        double price = 0;
        for(int i=0; i<flowers.length; i++){
            price = price + flowers[i].getPrice();
        }
        System.out.println("Bouquet price = " + price);
    }

    public void showFlowers(){
        for(int i=0; i<flowers.length; i++){
            System.out.println(flowers[i].getName());
        }
    }

    public void sortFlowersByFreshness(){
        for(int i=0; i<flowers.length; i++) {
            for (int j = flowers.length-1; j > i; j--){
                if ( flowers[j - 1].getFreshnessLevel() > flowers[j].getFreshnessLevel()) {
                    Flower tmp = flowers[j-1];
                    flowers[j-1] = flowers[j];
                    flowers[j] = tmp;
                }
            }

        }

    }

    public boolean findFlower(int lenghtStalk){
        boolean res = false;
        int counter = 0;
        for(int i=0; i<flowers.length-1; i++){
            if(flowers[i].getLenghtStalk() == lenghtStalk) {
                counter ++;
                res = true;
            }
        }
        if(counter == 0){
            res = false;
        }
        return res;
    }
}
