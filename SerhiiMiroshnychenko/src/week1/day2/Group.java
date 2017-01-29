package week1.day2;

import week1.day1.Student;

import java.util.Comparator;

/**
 * Created by serhiim on 22-Jan-17.
 */
public class Group {
    private String name;
    private Student[] students;

    // Method return string all students


    public Group() {
    }

    public Group(String name) {
        if (name == null || name.isEmpty()) return;
        this.name = name;
    }

    public Group(String name, Student[] students) {
        this.name = name;
        this.students = students;
    }

    public void setStudents(Student[] students) {
        if (students == null) return;
        this.students = students;
    }

    public void groupToString (){
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].toString());

        }
    }

    public Student[] getStudents() {
        return students;
    }

    public String getName() {
        return name;
    }

    public void addStudent(Student student){
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null){
                students[i] = student;
                break;
            }
        }
    }
    public void sort(Comparator comp){
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < students.length -1; i++) {
                if (comp.compare(students[i], students[i+1]) > 0) {
                    Student temp = students[i];
                    students[i] = students[i + 1];
                    students[i + 1] = temp;
                    flag = true;
                }
            }
        }

    }
}
