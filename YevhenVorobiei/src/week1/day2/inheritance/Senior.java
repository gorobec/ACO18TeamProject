package week1.day2.inheritance;

/**
 * Created by gorobec on 22.01.17.
 */
public class Senior extends Coder {
    public Senior(String name, String surname, int age, String programmingLanguage) {
        super(name, surname, age, programmingLanguage);
    }
    public void work(){
        System.out.println("I'm Senior, and I'm working");
    }

    public void seniorStaff(){}


}
