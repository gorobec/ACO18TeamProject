package week1.day2.car_task;

/**
 * Created by anastasiia.shvetsova on 1/23/2017.
 */
public class Engine {
    private int power;
    private int weight;
    private String type;
    private boolean state;

    public Engine(int power, int weight, String type, boolean state) {
        this.power = power;
        this.weight = weight;
        this.type = type;
        this.state = state;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
