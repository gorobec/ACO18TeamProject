package week1.homeWork.klassMaterial.auto;

/**
 * Created by Игорь on 23.01.2017.
 */
public class Wheel {
    private int diametr;
    private boolean winter;

    public Wheel(int diametr, boolean winter) {
        this.diametr = diametr;
        this.winter = winter;
    }

    public void setWinter(boolean winter) {
        this.winter = winter;
    }

    public boolean changeSummerWeel(boolean summer){
        if (summer) return false;
        else return true;
    }
}
