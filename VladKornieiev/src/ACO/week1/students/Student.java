package ACO.week1.students;

/**
 * Created by v21k on 24.01.17.
 */

public class Student implements Comparable {
    private String name;
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
//        validation
        if (name == null || name.isEmpty()) return;
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }

    @Override
    public String toString() {
        return String.format("student name - %s, surname - %s, age - %d", name, surname, age);
    }


    // equals() and compareTo() added

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (age != student.age) return false;
        if (!name.equals(student.name)) return false;
        return surname.equals(student.surname);
    }

    @Override
    public int compareTo(Object o) {
        Student st = (Student) o;
        return name.compareTo(st.name);
    }
}