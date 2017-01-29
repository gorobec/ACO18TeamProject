package week1.day1;

/**
 * Created by serhiim on 21-Jan-17.
 */
public class Student implements Comparable{

    private String name;
    private String surname;
    private int age;
    private double averageMark;
    private Cat cat = new Cat("Vasia", 2);


    public Student (){

    }

    public Student(String name, String surname, int age, double averageMark, Cat cat) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.averageMark = averageMark;
        this.cat = cat;
    }

    public int getAge() {
        return age;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public Student(String name, String surname, int age, double averageMark) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.averageMark = averageMark;
    }

    public Student(String name, String surname, int age) {
        this.name = name;

        this.surname = surname;
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) return;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Student name - %s, student surname - %s, age - %d, cat - %s", name, surname, age, cat.catToString());
    }


    @Override
    public int compareTo(Object o) {
        Student st = (Student) o;
        return name.compareTo(st.name);
    }
}
