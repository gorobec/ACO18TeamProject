package oop.weak1.task_5_books;

/**
 * Created by Администратор on 25.01.2017.
 */
public class Encyclopedia extends Book{

    public Encyclopedia(String name, String authorName, int pages) {
        super(name, authorName, pages);
    }

    @Override
    public void purpose() {
        System.out.println("Энциклопе́дия —  сборник научных сведений и справок на различные темы, предназначенный для обширного круга читателей.");
    }
}
