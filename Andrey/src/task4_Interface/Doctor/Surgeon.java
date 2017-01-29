package task4_Interface.Doctor;

/**
 * Created by Sherlock on 28.01.2017.
 */
public class Surgeon implements Doctor{

    private String name;
    private int exp;

    public Surgeon(String name, int exp) {
        this.exp = exp;
        this.name = name;

    }
    @Deprecated
    public void prescribemedications(){
        System.out.println("Take analgetic");
    }

    public void showDoctor(){
        System.out.printf("My name: %s.I'm neurosurgeon, experience in this field - %d year "  , name , exp );
    }
  //  public abstract void getWorkType();


}
