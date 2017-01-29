package week1day2.task2;

/**
 * Created by Валерий on 22.01.2017.
 */
public class TestPerson {
    public static void main(String[] args) {
        Person person = new Person("Ivan", "Ivanov", 30);
        System.out.println(person.asString());

        Coder coder = new Coder("Jora", "Sushkin", 34, "Java");
        System.out.println(coder.asString());
        coder.work();

        Coder coderJ = new Junior("Gena", "Bublikov", 34, "Java");
        System.out.println(coderJ.asString());
        coderJ.work();

        Coder coderM = new Middle("Jack", "Smith", 43, "Java");
        System.out.println(coderM.asString());
        coderM.work();

        Coder coderS = new Senior("Rick", "Hacker", 43, "Java");
        System.out.println(coderS.asString());
        coderS.work();

        Coder[] coders = {coder, coderJ, coderM, coderS};
        Manager manager = new Manager("John", "Grey", 30, coders);

        manager.work();
        manager.showCoders();
    }
}
