package oop.weak1.task_4_florist;

/**
 * Created by Администратор on 24.01.2017.
 */
public class Iris extends Flower {

    public Iris(String color, int freshness, int stemLengh, float cost) {
        super(color, freshness, stemLengh, cost);
    }

    public void asString() {
        System.out.printf("Ирис: цвет - %s, свежесть (0-10) - %d, длина стебля - %d, стоимость - %.2f\n", getColor(), getFreshness(), getStemLengh(), getCost());
    }
}
