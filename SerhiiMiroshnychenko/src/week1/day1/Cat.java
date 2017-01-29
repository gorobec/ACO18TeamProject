package week1.day1;

/**
 * Created by serhiim on 21-Jan-17.
 */
public class Cat {

    private String name;
    private int age;

    public Cat(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) return;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age == 0) return;
        this.age = age;
    }



    public String catToString(){
        return String.format("Cat name - %s, cat age - %d", name, age);
    }

    public static void main(String[] args) {
        Cat cat = new Cat("Vasia", 2);
        System.out.println(cat.catToString());

        cat.setName("");

        System.out.println(cat.getName());
    }
}
