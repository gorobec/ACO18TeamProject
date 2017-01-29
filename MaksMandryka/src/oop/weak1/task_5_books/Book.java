package oop.weak1.task_5_books;

/**
 * Created by Администратор on 25.01.2017.
 */
public abstract class Book implements Edition {

    private String name;
    private String authorName;
    private int pages;
    private String publisherName;
    private int circulation;
    private String editionDate;

    public Book(String name, String authorName, int pages) {
        this.name = name;
        this.authorName = authorName;
        this.pages = pages;

    }

    abstract public void purpose();

    public void read(int pages) {
        if (pages > this.pages) {
            System.out.printf("Было прочитано %d страниц книги %s\n", this.pages, name);
        } else if (pages <= 0) {
            return;
        } else {
            System.out.printf("Было прочитано %d страниц книги %s\n", pages, name);
        }

    }

    @Override
    public void publish(String publisherName, int circulation, String editionDate) {
        this.publisherName = publisherName;
        this.circulation = circulation;
        this.editionDate = editionDate;
        System.out.printf("Книга %s была издана %s издательством %s, тиражом %d экземпляров\n", name, editionDate, publisherName, circulation);
    }

}
