package week1.task1;

/**
 * Created by ksyashka on 23.01.2017.
 */
public class Engine {
    private int hp;
    private boolean engineIsOk;

    public Engine(int hp, boolean engineIsOk){
        this.hp = hp;
        this.engineIsOk = engineIsOk;
    }

    public boolean checkEngine(){
        return engineIsOk;
    }
}
