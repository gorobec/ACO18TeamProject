package week1.day2.Company;

/**
 * Created by serhiim on 22-Jan-17.
 */
public class Junior extends Coder{

    public Junior(String name, String surname, int age, String programmingLanguage) {
        super(name, surname, age, programmingLanguage);

    }

    @Override
    public void work() {
        System.out.println("I am junior. I am working");;
    }
}
