package ACO.week1.interfaces.book;

/**
 * Created by v21k on 25.01.17.
 */
public class Encyclopedia extends Book {


    public Encyclopedia(String name, int year) {
        super(name, year);
    }

    @Override
    public void getBookType() {
        System.out.println("I am encyclopedia.");
    }
}
