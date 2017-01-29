package oop.weak1.task_4_florist;

/**
 * Created by Администратор on 24.01.2017.
 */
public class Run {

    public static void main(String[] args) {

        Flower chamomile1 = new Chamomile("White", 9, 30, 15f);
        Flower chamomile2 = new Chamomile("White", 8, 25, 15f);
        Flower rose1 = new Rose("Red", 5, 40, 25f);
        Flower rose2 = new Rose("White", 6, 40, 25f);
        Flower rose3 = new Rose("Red", 8, 35, 25f);
        Flower iris1 = new Iris("Purple", 10, 22, 15f);
        Flower iris2 = new Iris("Purple", 7, 19, 15f);
        Flower tulip1 = new Tulip("Pink", 8, 30, 20f);
        Flower tulip2 = new Tulip("Yellow", 10, 27, 20f);

        Flower[] flowers = new Flower[9];

        flowers[0] = chamomile1;
        flowers[1] = chamomile2;
        flowers[2] = rose1;
        flowers[3] = rose2;
        flowers[4] = rose3;
        flowers[5] = iris1;
        flowers[6] = iris2;
        flowers[7] = tulip1;
        flowers[8] = tulip2;

        Accessories accessory1 = new Accessories("Wrapper", 15f);
        Accessories accessory2 = new Accessories("Tape", 10f);

        Accessories[] accessories = new Accessories[2];

        accessories[0] = accessory1;
        accessories[1] = accessory2;

        Bouquet bouquet = new Bouquet(flowers, accessories);

        System.out.println("Стоимость букета " + bouquet.value());

        bouquet.sortFlowersByFreshness();

        System.out.println("Сортировка");
        for (Flower fl : bouquet.getFlowerSet()) {
            fl.asString();
        }

        Flower[] flowers2 = bouquet.findFlowersByStemLength(30, 35);

        System.out.println("Отбор по длине стебля");
        for (Flower fl : flowers2) {
            fl.asString();
        }

    }
}
