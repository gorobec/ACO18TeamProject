package week1.day2.Company;

import week1.day1.Student;

/**
 * Created by serhiim on 22-Jan-17.
 */
public class Run {
    public static void main(String[] args) {
        Person person = new Person("Vasia", "Petrov", 20);
        System.out.println(person.asString());
        Coder coder1 = new Senior("Petia", "Vasiliev", 25, "Java");
        Coder coder2 = new Middle("Vasia", "Petrov", 23, "Java");
        Coder coder3 = new Junior("Ivan", "Ivanov", 23, "Java");
        System.out.println(coder1.asString());

        Coder[] coders = {coder1, coder2, coder3};

        Manager manager = new Manager("Ivan", "Petrov", 23, coders);

        System.out.println(manager.asString());

        manager.work();
    }
}
