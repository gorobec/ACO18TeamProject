package week1.day1.student;

public class Student implements Comparable {

    private String name;
    private String surName;
    private int age;
    private double avarageMark;

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public double getAvarageMark() {
        return avarageMark;
    }

    public void setAvarageMark(double mark) {
        avarageMark = mark;
    }

    public Student(String surName) {
        this.surName = surName;
    }

    public Student(String name, String surName, int age, double avarageMark) {
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.avarageMark = avarageMark;
    }

    public String asString() {
        return String.format("Student name - %8s, surname - %10s , age - %d, avarageMark - %6.2f",
                name, surName, age, avarageMark);

    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (obj.getClass() == this.getClass()) {
            Student student = (Student) obj;
            if (student.name.equals(this.name) && student.surName.equals(this.surName) && student.age == this.age)
                return true;
        }
        return false;
    }

    @Override
    public int compareTo(Object o) {
        Student student = (Student) o;
        return this.getName().compareTo(student.getName());
    }
}
