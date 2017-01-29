package week1.taskinterfaces.issue;

/**
 * Created by ksyashka on 25.01.2017.
 */
public abstract class Book implements Issue {
    private String name;
    private int pages;

    public Book(String name, int pages) {
        this.name = name;
        this.pages = pages;
    }

    public String toString() {
        return String.format("Name - %12s, pages - %4d", name, pages);
    }

    public void print() {
        System.out.println(this);
    }


}
