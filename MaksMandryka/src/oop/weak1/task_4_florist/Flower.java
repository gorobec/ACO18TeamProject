package oop.weak1.task_4_florist;

import java.util.Formatter;

/**
 * Created by Администратор on 24.01.2017.
 */
public class Flower implements Comparable<Flower> {

    private String color;
    private int freshness;
    private int stemLengh;
    private float cost;

    public Flower(String color, int freshness, int stemLengh, float cost)  {
        this.color = color;
        this.freshness = freshness;
        this.stemLengh = stemLengh;
        this.cost = cost;
    }

    public String getColor() {
        return color;
    }

    public int getFreshness() {
        return freshness;
    }

    public int getStemLengh() {
        return stemLengh;
    }

    public float getCost() {
        return cost;
    }

    public void asString() {
        System.out.printf("Цветок: цвет - %s, свежесть (0-10) - %d, длина стебля - %d, стоимость - %f\n",color,freshness,stemLengh,cost);
    }

    public int compareTo(Flower flower) {
        return freshness - flower.getFreshness();
    }
}
