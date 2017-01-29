package oop.weak1.task_5_books;

/**
 * Created by Администратор on 25.01.2017.
 */
public class Run {
    public static void main(String[] args) {

        Book compendium = new Compendium("КОМПЕНДИУМ 2015 — лекарственные препараты", "Автор1", 1500);

        compendium.publish("Морион",5000,"20 Февраля 2015");

        Book encyclopedia = new Encyclopedia("Всемирная история", "Автор2", 1000);

        encyclopedia.publish("Олма", 10000,"10 марта 2016");

        compendium.purpose();
        encyclopedia.purpose();

    }
}
