package week1.day2;

import week1.day1.Student;

/**
 * Created by serhiim on 22-Jan-17.
 */
public class MainStudent {
    public static void main(String[] args) {
        Student student1 = new Student("Ivan", "Petrov", 20);
        Student student2 = new Student("Petr", "Ivanov", 21);
        Student student3 = new Student("Vasilii", "Semenov", 19);
        Student student4 = new Student("Serhii", "Lobov", 19);
        Student student5 = new Student("Yaroslav", "Petrov", 19);
        Student student6 = new Student("Maksim", "Litvininko", 19);
        Student student7 = new Student("Alex", "Ivanov", 19);
        Student student8 = new Student("Semen", "Baguk", 19);

        Student[] students1 = {student1, student2, student3, student4};
        Student[] students2 = {student5, student6, student7, student8};


        Group group1 = new Group("Group 1");
        group1.setStudents(students1);
        Group group2 = new Group("Group 2");
        group2.setStudents(students2);

        Group group3 = new Group("Group 3");

        Student[] students = new Student[2];
        group3.setStudents(students);

        group3.addStudent(student8);
        group3.addStudent(student1);

        Group[] groups = {group1, group2, group3};


        University university = new University("KPI");
        university.setGroups(groups);

        System.out.println("Show Student");
        System.out.println(student1.toString());
        System.out.println();

        System.out.println("Show group 1");
        group1.groupToString();
        System.out.println();

        System.out.println("Show group 2");
        group2.groupToString();
        System.out.println();

        System.out.println("Show group 3");
        group3.groupToString();
        System.out.println();

        System.out.println("Show groups");
        university.showGroups();
        System.out.println();

        System.out.println("Show groups students");
        university.showStudents();

    }
}
