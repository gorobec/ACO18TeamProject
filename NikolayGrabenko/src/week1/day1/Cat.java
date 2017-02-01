package week1.day1;

/**
 * Created by User on 21.01.2017.
 */
public class Cat {

    private String name;
    private int age;
    private String color;

    public Cat() {
    }

    public Cat(String name, String color) {
        this.name = name;
        this.color = color;
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
