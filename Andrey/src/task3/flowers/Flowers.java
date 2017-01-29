package task3.flowers;

/**
 * Created by Sherlock on 27.01.2017.
 */
public class Flowers {

    private int stemLength;
    private double price;
    private int freshnes;

    protected Flowers(int stemLength, double price, int freshnes) {

        this.stemLength = stemLength;
        this.price = price;
        this.freshnes = freshnes;
    }


    public double getSremLength() {
        return stemLength;
    }

    public void setSremLength(int sremLength) {
        this.stemLength = sremLength;
    }

    public double getPrice() {
        return price;
    }

    public int getFreshnes() {
        return freshnes;
    }

   public String toString(){
       return String.format("Stem length - %d , price - %s , freshnes - %d", stemLength , price , freshnes);
   }
}
