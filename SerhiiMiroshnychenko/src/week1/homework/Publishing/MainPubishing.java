package week1.homework.Publishing;

/**
 * Created by serhiim on 26-Jan-17.
 */
public class MainPubishing {

    public static void main(String[] args) {
        Book encyclopedia = new Encyclopedia("Arround the world", 532);
        Book handbook = new Handbook("Java handbook", 150);

        System.out.println("*********************");
        System.out.println("Encyclopedia");
        System.out.println("*********************");
        System.out.println(encyclopedia.getClassName());
        System.out.println(encyclopedia.getBookName());
        System.out.println(encyclopedia.getPageCount());
        System.out.println();

        System.out.println("*********************");
        System.out.println("Handbook");
        System.out.println("*********************");
        System.out.println(handbook.getClassName());
        System.out.println(handbook.getBookName());
        System.out.println(handbook.getPageCount());
        System.out.println();

    }
}
