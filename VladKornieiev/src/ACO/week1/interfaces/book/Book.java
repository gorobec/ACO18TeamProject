package ACO.week1.interfaces.book;

/**
 * Created by v21k on 25.01.17.
 */
public abstract class Book implements Edition {
    private String name;
    private int year;

    public Book(String name, int year) {
        this.name = name;
        this.year = year;
    }

    @Override
    public void print() {
        System.out.printf("Book %s will be printed. Edition number: %d\n", name, editionNumber);
    }

    public abstract void getBookType();
}
