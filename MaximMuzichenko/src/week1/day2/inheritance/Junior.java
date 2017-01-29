package week1.day2.inheritance;

/**
 * Created by gorobec on 22.01.17.
 */
public class Junior extends Coder {
    public Junior(String name, String surname, int age, String programmingLanguage) {
        super(name, surname, age, programmingLanguage);
    }
    public void work(){
        System.out.println("I'm junior, and I'm working");
    }

    public void juniorStaff(){}

}
