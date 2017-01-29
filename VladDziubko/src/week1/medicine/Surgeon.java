package week1.medicine;

/**
 * Created by Reed on 25.01.2017.
 */
public class Surgeon implements IDoctor {
    private String doctorType;

    public Surgeon(){
        doctorType = "Surgeon";
    }

    public Surgeon(String doctorType){
        this.doctorType = doctorType;
    }

    public StringBuilder doctorType(){
        return new StringBuilder("I`m  a surgeon");
    }

}
