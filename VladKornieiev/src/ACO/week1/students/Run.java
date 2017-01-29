package ACO.week1.students;

import ACO.week1.students.comparators.ByAgeComparator;
import ACO.week1.students.comparators.ByNameComparator;
import ACO.week1.students.comparators.BySurnameComparator;

/**
 * Created by v21k on 24.01.17.
 */

public class Run {
    public static void main(String[] args) {
        Student student = new Student("John", "Bmith", 35);
        Student student2 = new Student("Jack", "Smith", 25);
        Student student3 = new Student("Jack", "Kmith", 15);
        Student student4 = new Student("Ann", "Lmith", 45);
        Student student5 = new Student("Mike", "Cmith", 55);
        Student student6 = new Student("Bill", "Dmith", 17);
        Student student7 = new Student("Kate", "Omith", 23);
        Student student8 = new Student("Bob", "Xmith", 33);
        Student student9 = new Student("John", "Jmith", 35);

        Student[] students = {student, student2, student3, student4};
        Student[] students2 = {student5, student6, student7, student8};

        Group group = new Group("ACO17", students);
        Group group2 = new Group("ACO18", students2);
        Group group7 = new Group("ACO18", students2);

        Group[] groups = {group, group2};

        University university = new University("KNU", groups);
        System.out.println("Groups:");
        university.showGroups();
        System.out.println("Students:");
        university.showStudents();

        // -----------------------

        // homework tests

        // -----------------------

        System.out.println("HW tests:");
        group.showStudents();
        group.addStudent(student2);
        group.showStudents();

        group.removeLastStudent();
        group.showStudents();
        System.out.println();

        group.searchStudentByName("Ann");
        group.searchStudentByName("Katya");

        group.sortByName();
        group.showStudents();

        System.out.println();
        group.removeStudentByName("Jack");
        group.showStudents();

        System.out.println();
        university.removeGroupByName("ACO17");
        university.showGroups();

        System.out.println();

        // -----------------------

        // equals() tests

        // -----------------------

        //adding existing student/group
        group.addStudent(student9);
        university.addGroup(group7);

        System.out.println();

        // same name-surname, different age - OK
        System.out.println(student2.equals(student3));
        // different groups - OK
        System.out.println(group.equals(group2));

        // same groups - OK
        Group group3 = new Group("ACO17", students);
        Group group4 = new Group("ACO17", students);
        System.out.println(group3.equals(group4));

        // same groups - different students - OK
        Group group5 = new Group("ACO17", students);
        Group group6 = new Group("ACO17", students2);
        System.out.println(group5.equals(group6));

        // -----------------------

        // comparable tests

        // -----------------------

        System.out.println();
        group5.showStudents();
        System.out.println("By surname");
        group5.sort(new BySurnameComparator());
        group5.showStudents();
        System.out.println("By name");
        group5.sort(new ByNameComparator());
        group5.showStudents();
        System.out.println("By age");
        group5.sort(new ByAgeComparator());
        group5.showStudents();

        System.out.println();
        System.out.println(group5.searchStudentByNameBinary("Jack"));
        System.out.println(group5.searchStudentByNameBinary("Anya"));
        System.out.println(group5.searchStudentByNameBinary("Kolia"));
    }
}
