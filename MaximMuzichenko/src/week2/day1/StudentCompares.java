package week2.day1;

import week1.day2.student_task.Student;

import java.util.Arrays;

/**
 * Created by gorobec on 28.01.17.
 */
public class StudentCompares {
    public static void main(String[] args) {
        Student student = new Student("John", "Smith", 35);
        Student student2 = new Student("Jack", "Smith", 25);
        Student student3 = new Student("Sara", "Smith", 15);
        Student student4 = new Student("Ann", "Smith", 45);
        Student student5 = new Student("Mike", "Smith", 55);
        Student student6 = new Student("Bill", "Smith", 17);
        Student student7 = new Student("Kate", "Smith", 23);
        Student student8 = new Student("Bob", "Smith", 33);


        Student[] students = {student, student2, student3, student4, student5, student6, student7, student8};
        students[0] = null;
        System.out.printf("");
        /*System.out.println(Arrays.toString(students));
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
        Arrays.sort(students, new AgeComparator());
        System.out.println(Arrays.toString(students));*/

    }
}
