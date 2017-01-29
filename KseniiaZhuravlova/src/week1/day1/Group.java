package week1.day1;

import java.util.*;
import week2.day1.*;

/**
 * Created by ksyashka on 22.01.2017.
 */
public class Group {
    private String name;
    private int size;
    private Student[] students;


    public Group() {
    }

    public Group(String name, int size) {
        this.name = name;
        this.students = new Student[size];
    }


    public boolean addStudent(String name, String surname, int age) {
        if (size == students.length) {
            System.out.println("Sorry! Group is ful!");
            return false;
        }
        Student student = new Student(name, surname, age);
        if (isDuplicateStudent(student)) {
            System.out.println("A student is already in the group");
            return false;
        }
        students[size++] = new Student(name, surname, age);
        return true;
    }

    public boolean addStudent(String name, String surname, int age, double averageMark) {
        if (size == students.length) {
            System.out.println("Sorry! Group is ful!");
            return false;
        }
        Student student = new Student(name, surname, age, averageMark);
        if (isDuplicateStudent(student)) {
            System.out.println("A student is already in the group");
            return false;
        }
        students[size++] = new Student(name, surname, age, averageMark);
        return true;
    }

    public boolean isDuplicateStudent(Student student) {
        if (student == null) return false;
        for (int i = 0; i < size; i++)
            if (students[i].equals(student)) return true;
        return false;
    }

    public void delStudent(int index) {
        if (index < 0 || index > students.length || students[index] == null) {
            System.out.println("A student doesn't exist!");
            return;
        }
        System.arraycopy(students, index + 1, students, index, students.length - index - 1);
        students[students.length - 1] = null;
        size--;
    }


    public String asString() {
        return String.format("Group name - %s, Students  - %d", name, students.length);
    }

    public void showStudents() {
        System.out.println(name);
        for (int i = 0; i < students.length; i++)
            if (students[i] != null)
                System.out.println(students[i].asString());
    }

    public void searchStudent(String name) {
        System.out.println("Students with name " + name + " in group " + this.name);
        for (int i = 0; i < students.length; i++)
            if (students[i] != null && students[i].getName().equals(name)) System.out.println(students[i].asString());
    }


    public void sort() {
        Student[] temp = new Student[size];
        System.arraycopy(students,0, temp, 0, size);
        Arrays.sort (temp);
        System.arraycopy(temp,0, students, 0, size);
    }

      /*  public Student[] sortStudents() {
        int len = students.length;
        Student temp;
        for (int i = len - 1; i > 0; i--)
            for (int j = 0; j < i; j++)
                if (students[j + 1] != null && students[j].getName().compareTo(students[j + 1].getName()) > 0) {
                    temp = students[j + 1];
                    students[j + 1] = students[j];
                    students[j] = temp;
                }
        return students;
    }*/

    public void sort(Comparator comparator) {
        int len = students.length;
        Student temp;
        for (int i = len - 1; i > 0; i--)
            for (int j = 0; j < i; j++)
                if ((comparator.compare(students[j],students[j+1])>0)) {
                    temp = students[j + 1];
                    students[j + 1] = students[j];
                    students[j] = temp;
                }
    }

    @Override
    public boolean equals(Object group) {
        if(group == null || !(group instanceof Group)) return false;
        Group temp = (Group) group;
        if (this == group) return true;
        if (!this.name.equals(temp.name)) return false;
        for (int i = 0; i < size; i++)
            if (!this.students[i].equals(temp.students[i])) return false;
        if (this.size != temp.size) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
