package week1.day2.Company;

/**
 * Created by serhiim on 22-Jan-17.
 */
public class Senior extends Coder {
    public Senior(String name, String surname, int age, String programmingLanguage) {
        super(name, surname, age, programmingLanguage);
    }

    @Override
    public void work() {
        System.out.println("I am senior. I am working");;
    }
}
