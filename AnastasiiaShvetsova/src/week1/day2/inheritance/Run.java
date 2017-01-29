package week1.day2.inheritance;

/**
 * Created by gorobec on 22.01.17.
 */
public class Run {
    public static void main(String[] args) {
        Person person = new Person("Name", "Surname", 15);
        System.out.println(person.asString());

        Senior coder = new Senior("Jack", "Smith", 30, "Java");
        System.out.println(coder.asString());
        Middle coder2 = new Middle("John", "Smith", 35, "C++");
        System.out.println(coder2.asString());
        Junior coder3 = new Junior("Ann", "Smith", 20, "JS");
        System.out.println(coder3.asString());


        Coder[] coders = {coder, coder2,  coder3};

        Manager manager = new Manager("Sergey", "Lopt", 30, 5, coders);
        System.out.println(manager.asString());
        manager.showCoders();
        manager.work();

    }
}
