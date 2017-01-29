package week1.day2.inheritance;

/**
 * Created by gorobec on 22.01.17.
 */
public class Middle extends Coder {
    public Middle(String name, String surname, int age, String programmingLanguage) {
        super(name, surname, age, programmingLanguage);
    }
    public void work(){
        System.out.println("I'm middle, and I'm working");
    }
    public void middleStaff(){}


}
