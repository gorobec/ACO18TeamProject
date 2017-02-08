package week1.day2;

/**
 * Created by User on 22.01.2017.
 */
public class Test {
    public static void main(String[] args) {

        Codder c1 = new Codder("Andrey","Ivanov",25,"java");
        Codder c2 = new Codder("Sasha","Petrov",28,"C++");
        Codder c3 = new Codder("Serg","Sydorov",26,"java");

        Codder [] codders = {c1, c2, c3};

        Manager man = new Manager("Misha", "Gorbachev",42,15,codders);

        System.out.println(man.asString());
    }
}
