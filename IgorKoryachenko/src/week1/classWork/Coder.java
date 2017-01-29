package week1.classWork;
//jdhslhl

/**
 * Created by Игорь on 22.01.2017.
 */
public class Coder extends Person {
    private String programingLang;

    public Coder(String programingLang) {
        this.programingLang = programingLang;
    }

    public Coder(String name, String surname, int age, String programingLang) {
        super(name, surname, age);
        this.programingLang = programingLang;
    }

    @Override
    public String asString() {
        return super.asString() + "  Lang - " + programingLang;
    }
}
