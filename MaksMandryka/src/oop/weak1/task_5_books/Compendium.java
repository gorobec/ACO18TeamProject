package oop.weak1.task_5_books;

/**
 * Created by Администратор on 25.01.2017.
 */
public class Compendium extends Book{

    public Compendium(String name, String authorName, int pages) {
        super(name, authorName, pages);
    }

    @Override
    public void purpose() {
        System.out.println("Спра́вочник — издание практического назначения, с кратким изложением сведений в систематической форме, в расчёте на выборочное чтение, на то, чтобы можно было быстро и легко навести по нему справку.");
    }
}
