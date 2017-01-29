package week1.day1;

/**
 * Created by gorobec on 21.01.17.
 */
public class IntroInReferen {
    public static void main(String[] args) {
        String name = "Yevhen";
        String name2 = "Maxim";

//        Student stud1 = new Student();
//        stud1.name = "Maxim";
//        stud1.age = 29;

        Student stud2 = new Student("Yevhen", "Vorobiei", 27);

        Cat cat = new Cat("Vas'ka", 5);


        System.out.println(stud2.asString());
    }
}
