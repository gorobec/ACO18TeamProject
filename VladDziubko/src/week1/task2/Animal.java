package week1.task2;

public class Animal {
    private String name;
    private int age;
    private double weight;
    private String kind;

    public Animal(String name, int age, double weight, String kind) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.kind = kind;
    }

    public Animal() {
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public String getKind() {
        return kind;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void run() {
        System.out.println("Animal " + getName() + " is running very fast.");
    }

    public void jump() {
        System.out.println("Animal " + getName() + " is jumping.");
    }
}
