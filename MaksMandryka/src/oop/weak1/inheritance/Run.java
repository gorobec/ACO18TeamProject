package oop.weak1.inheritance;

/**
 * Created by fmandryka on 22.01.2017.
 */
public class Run {
    public static void main(String[] args) {

        Person pers = new Person("Name", "surname", 23);
        System.out.println(pers.asString());
        Codder cod = new Codder("John", "Smith", 34, "Java");
        Codder cod2 = new Codder("Max", "M", 27, "Java");
        System.out.println(cod.asString());


        Codder[] codders = new Codder[2];
        codders[0] = cod;
        codders[1] = cod2;
        Manager man = new Manager("John", "Smith", 34, "Teva", codders);
        System.out.println(man.asString());
        man.work();

        Senior codder1 = new Senior("Max", "M", 27, "Java");
        Middle codder2 = new Middle("Max", "M", 27, "Java");
        Junior codder3 = new Junior("Max", "M", 27, "Java");

    }


}
