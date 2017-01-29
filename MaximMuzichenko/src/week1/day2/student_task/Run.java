package week1.day2.student_task;

import java.util.Arrays;

/**
 * Created by gorobec on 22.01.17.
 */
public class Run {
    public static void main(String[] args) {
        Student student = new Student("John", "Smith", 35);
        Student student2 = new Student("Jack", "Smith", 25);
        Student student3 = new Student("Sara", "Smith", 15);
        Student student4 = new Student("Ann", "Smith", 45);
        Student student5 = new Student("Mike", "Smith", 55);
        Student student6 = new Student("Bill", "Smith", 17);
        Student student7 = new Student("Kate", "Smith", 23);
        Student student8 = new Student("Bob", "Smith", 33);

        Student[] students = {student, student2, student3, student4};
        Student[] students2 = {student5, student6, student7, student8};

        Group group = new Group("ACO17", students);
        Group group2 = new Group("ACO18", students2);

        System.out.println(Arrays.toString(group.getStudents()));
        group.sortByName();
        System.out.println(Arrays.toString(group.getStudents()));

        /*Group[] groups = {group, group2};

        University university = new University("KNU", groups);
        System.out.println("Groups:");
        university.showGroups();
        System.out.println("Students:");
        university.showStudents();*/
    }
}
