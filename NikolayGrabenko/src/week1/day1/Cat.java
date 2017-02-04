package week1.day1;

import java.util.ArrayList;

/*Статические коты
1. В классе Cat добавь public статическую переменную cats (ArrayList<Cat>).
2. Пусть при каждом создании кота (нового объекта Cat) в переменную cats добавляется этот новый кот. Создать 10 объектов Cat.
3. Метод printCats должен выводить всех котов на экран. Нужно использовать переменную cats.
*/
public class Cat {

    private String name;
    private String color;
    public static ArrayList <Cat> cats = new ArrayList<>();

    public Cat(String name, String color) {
        this.name = name;
        this.color = color;
        cats.add(this);
    }

    public static boolean printCats (ArrayList <Cat> cats) {
        for (Cat cat : cats){
            System.out.println(String.format("Name - %10s, color - %10s", cat.name, cat.color));
        }
    return  true;
    }

    public String asString() {
        return String.format("Name - %s, color - %s", name, color);
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        if (color == null || color.isEmpty()) return;
        else
            this.color = color;

    }
}
