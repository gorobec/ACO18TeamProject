package week1.homework.student;

import java.util.Comparator;
import java.util.Objects;

/**
 * Created by serhiim on 23-Jan-17.
 */
public class Student implements Comparable{

    private String name;

    public int getAge() {
        return age;
    }

    private String surname;
    private int age;
    private double averageMark;


    public Student(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) return;
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        if (this == o) return 0;
        if (o != null && o instanceof Student){
            Student temp = (Student) o;
            return this.name.compareTo(temp.name);
        }
        return -1;
    }

    @Override
    public String toString() {
        return String.format("Student name - %s, student surname - %s, age - %d", name, surname, age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (age != student.age) return false;
        if (Double.compare(student.averageMark, averageMark) != 0) return false;
        if (!name.equals(student.name)) return false;
        return surname.equals(student.surname);
    }

}
