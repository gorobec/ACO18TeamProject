package week1.homework.automobile;

/**
 * Created by serhiim on 22-Jan-17.
 */
public class Wheel {
    private boolean isBroken = false;

    public Wheel() {
    }

    public boolean getIsBroken() {
        return isBroken;
    }

    public void setIsBroken(boolean broken) {
        isBroken = broken;
    }

    public void startSpinning(){
        System.out.println("Wheel is spinning.");
    }
}
