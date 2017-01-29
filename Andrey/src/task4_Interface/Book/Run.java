package task4_Interface.Book;

/**
 * Created by Sherlock on 28.01.2017.
 */
public class Run {
    public static void main(String[] args) {

        Directory directory = new Directory("Kiev phone directory", 2015);
        directory.showBook();
        System.out.println();
        directory.getBookType();

        Encyclopedia encyclopedia = new Encyclopedia("Flowers", 2000);
        encyclopedia.getBookType();
        encyclopedia.showBook();
    }
}
