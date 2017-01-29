package oop.weak1.university;

import java.util.Comparator;

/**
 * Created by fmandryka on 21.01.2017.
 */
public class Student implements Comparable<Student> {
    private String name;
    private String surname;
    private int age;
    private double averageMark;
    private Cat cat;


    public Student(String name, String surname, int age, double averageMark) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.averageMark = averageMark;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public int getAge() {

        return age;
    }

    public String getSurname() {

        return surname;
    }

    public String getName() {

        return name;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public String asString() {
        return String.format("Student name - %s, surname - %s, age - %d, average mark - %f", name, surname, age, averageMark);
    }

    @Override
    public int compareTo(Student student) {

        if (name.compareTo(student.getName()) != 0) {

            return name.compareTo(student.getName());

        } else {

            if (surname.compareTo(student.getSurname()) != 0) {
                return surname.compareTo(student.getSurname());
            } else {
                return age - student.getAge();
            }
        }
    }


    @Override
    public boolean equals(Object student) {

        if (this == student) return true;

        if (student == null) return false;

        if (student instanceof Student) {

            Student stud = (Student) student;
            if (name.equals(stud.getName()) && surname.equals(stud.getSurname()) && age == stud.getAge() && averageMark == stud.getAverageMark()) {
                return true;
            }
        }
        return false;
    }


}
