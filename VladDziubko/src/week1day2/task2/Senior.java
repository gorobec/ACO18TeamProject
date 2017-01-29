package week1day2.task2;

/**
 * Created by Валерий on 22.01.2017.
 */
public class Senior extends Coder{
    public Senior(String name, String surname, int age, String progarammingLanguage) {
        super(name, surname, age, progarammingLanguage);
    }

    public void work(){
        System.out.println("I`m senior, i won`t work!");
    }
}
