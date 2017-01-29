package week1.homework.Publishing;

/**
 * Created by serhiim on 26-Jan-17.
 */
public abstract class Book implements Pub {
    protected String name;
    protected int pagesCount;


    public Book(String name, int pagesCount) {
        this.name = name;
        this.pagesCount = pagesCount;
    }
    
}
