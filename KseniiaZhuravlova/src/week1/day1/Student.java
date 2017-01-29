package week1.day1;

/**
 * Created by ksyashka on 22.01.2017.
 */

public class Student implements Comparable {
    private String name;
    private String surname;
    private int age;
    private double averageMark;

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }

    public Student() {
    }

    ;

    public Student(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }


    public Student(String name, String surname, int age, double averageMark) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.averageMark = averageMark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        // validation
        if (name == null || name.isEmpty()) return;
        this.name = name;
    }

    public String asString() {
        return String.format("Student name - %s, surname - %s, age - %d", name, surname, age);
    }

    @Override
    public boolean equals(Object student) {
        if (student == null || !(student instanceof Student)) return false;
        Student temp = (Student) student;
        if (this == student) return true;
        if (!this.name.equals(temp.name)) return false;
        if (!this.surname.equals(temp.surname)) return false;
        if (this.age != temp.age) return false;
        if (this.averageMark != temp.averageMark) return false;
        return true;
    }

    @Override
    public int compareTo(Object student) {
        if (student == null || !(student instanceof Student)) return -1;
        Student temp = (Student) student;
        return name.compareTo(temp.name);
    }
}
