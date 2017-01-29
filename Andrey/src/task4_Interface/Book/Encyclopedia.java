package task4_Interface.Book;

/**
 * Created by Sherlock on 28.01.2017.
 */
public class Encyclopedia extends Book {

    public Encyclopedia(String name, int year) {
        super(name, year);
    }

    @Deprecated
    public void getBookType() {
        System.out.println("I'm Encyclopedia");
    }

}
