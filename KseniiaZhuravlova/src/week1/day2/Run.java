package week1.day2;

/**
 * Created by ksyashka on 22.01.2017.
 */
public class Run {
    public static void main(String arg[]) {
        Person person = new Person("Jack", "Smith", 23);
        System.out.println(person.asString());
        Coder coder1 = new Coder("Smith", "Jack", 24, "java");
        System.out.println(coder1.asString());
        Coder coder2 = new Coder("John", "Adams", 28, "perl");
        Coder[] coders = {coder1, coder2};
        Manager manager = new Manager ("Ivan", "Ivanov", 35, "380990000000", coders);
        System.out.println(manager.asString());

        manager.showInfo();

        manager.work();

    }
}
