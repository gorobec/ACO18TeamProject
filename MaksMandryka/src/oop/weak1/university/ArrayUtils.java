package oop.weak1.university;

/**
 * Created by fmandryka on 24.01.2017.
 */
public class ArrayUtils {

    public static Student[] addElement(Student[] students, Student student) {

        Student[] studentsNew = new Student[students.length + 1];
        System.arraycopy(students, 0, studentsNew, 0, students.length);
        studentsNew[students.length] = student;
        return studentsNew;
    }

}
