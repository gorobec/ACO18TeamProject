package week1.task4;

/**
 * Created by ksyashka on 23.01.2017.
 */
public class Rose extends Flower {

    public Rose(int cost, int stemLength){
        super(cost, stemLength);
    }

    @Override
    public String toString(){
        return "Rose: "+super.toString();
    }
}
