package week1.homeWork.klassMaterial.auto;

/**
 * Created by Игорь on 23.01.2017.
 */
public class Auto {
    private String mark;
    private Wheel wheel;
    private Engine engine;

    public Auto(String mark, Wheel wheel, Engine engine) {
        this.mark = mark;
        this.wheel = wheel;
        this.engine = engine;
    }

    public String getMark() {
        return mark;
    }

    public Wheel getWheel() {
        return wheel;
    }

    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }

    public boolean fullFuel(){
        System.out.println("Машина заправлена");
        return true;
    }

    public void carRun(){
        if (fullFuel()) System.out.println("Машина едет");
    }

}
