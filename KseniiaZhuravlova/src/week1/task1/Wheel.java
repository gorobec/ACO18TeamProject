package week1.task1;

/**
 * Created by ksyashka on 23.01.2017.
 */
public class Wheel {
    private int diam;
    private boolean isWheelOk;

    public Wheel(){
    }

    public Wheel(int diam, boolean isWheelOk){
        this.diam = diam;
        this.isWheelOk = isWheelOk;
    }

    public boolean checkWheel(){
        return isWheelOk;
    }

    public void breakWheel() {
        isWheelOk = false;
    }

    public boolean changeWheel(int diam){
        this.isWheelOk = true;
        this.diam = diam;
        return true;
    }
}
