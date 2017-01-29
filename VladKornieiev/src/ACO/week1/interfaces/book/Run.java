package ACO.week1.interfaces.book;

/**
 * Created by v21k on 25.01.17.
 */
public class Run {
    public static void main(String[] args) {
        Manual manual = new Manual("Book1", 1999);
        manual.print();
        manual.getBookType();

        Encyclopedia encyclopedia = new Encyclopedia("Animals", 2015);
        encyclopedia.print();
        encyclopedia.getBookType();

    }
}
