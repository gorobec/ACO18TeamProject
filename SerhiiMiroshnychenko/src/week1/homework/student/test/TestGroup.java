package week1.homework.student.test;

import week1.homework.student.Group;
import week1.homework.student.Student;

/**
 * Created by serhiim on 24-Jan-17.
 */
public class TestGroup {

    public static void main(String[] args) {

        testGroupToString1();
        testGroupToString2();
        testAddStudent();
        testRemoveStudent();
        testFindStudentByName();
        testSortStudents();

    }

    private static void testGroupToString1() {
        Student student1 = new Student("qwe", "ewq", 23);
        Student student2 = new Student("asd", "dsa", 22);
        Student[] students = {student1, student2};
        Group group = new Group("Group1", students);

        String expected =
                "Student name - qwe, student surname - ewq, age - 23\n" +
                "Student name - asd, student surname - dsa, age - 22\n";
        String actual = group.toString();

        assert actual.equals(expected):"toString test fail. \nActual: \n" + actual + "\nExpected: \n" + expected;
    }

    private static void testGroupToString2() {
        Student student1 = null;
        Student student2 = new Student("asd", "dsa", 22);
        Student[] students = {student1, student2};
        Group group = new Group("Group1", students);

        String expected = "Student name - asd, student surname - dsa, age - 22\n";
        String actual = group.toString();

        assert actual.equals(expected):"toString with Student = null test fail. \nActual: \n" + actual + "\nExpected: \n" + expected;

    }

    private static void testAddStudent() {
        Student student1 = new Student("qwe", "ewq", 23);
        Student student2 = new Student("asd", "dsa", 22);
        Student[] students = {student1};
        Group group = new Group("Group1", students);
        group.addStudent(student2);

        int expectedLength = 2;
        int actualLength = group.getStudents().length;

        assert expectedLength == actualLength:"addStudent test failed.\n Actual array length:  " + actualLength
                + "\n Expected array length: " + expectedLength;

        String expectedName = "asd";
        String actualName = group.getStudents()[1].getName();
        assert actualName.equals(expectedName):"addStudent test failed.\n Actual added student name:  " + actualName
                + "\n Expected added student name: " + expectedName;
    }

    private static void testRemoveStudent() {
        Student student1 = new Student("qwe", "ewq", 23);
        Student student2 = new Student("asd", "dsa", 22);
        Student[] students = {student1, student2};
        Group group = new Group("Group1", students);

        group.removeStudent(0);
        int expectedLength = 1;
        int actualLength = group.getStudents().length;

        assert expectedLength == actualLength:"removeStudent test failed.\n Actual array length:  " + actualLength
                + "\n Expected array length: " + expectedLength;

        String expectedName = "asd";
        String actualName = group.getStudents()[0].getName();
        assert actualName.equals(expectedName):"removeStudent test failed.\n Actual student name that left:  " + actualName
                + "\n Expected student name that left: " + expectedName;
    }

    private static void testFindStudentByName(){
        Student student1 = new Student("qwe", "ewq", 23);
        Student student2 = new Student("asd", "dsa", 22);
        Student[] students = {student1, student2};
        Group group = new Group("Group1", students);

        String actual = group.findStudentByName("asd");
        String expected = "Student name - asd, student surname - dsa, age - 22";

        assert actual.equals(expected):"findStudent test fail. \nActual: \n" + actual + "\nExpected: \n" + expected;


    }

    private static void testSortStudents(){
        Student student1 = new Student("qwe", "ewq", 23);
        Student student2 = new Student("asd", "dsa", 22);
        Student student3 = new Student("zxc", "cxz", 27);
        Student student4 = new Student("rty", "yrt", 25);
        Student[] students = {student1, student2, student3, student4};
        Group group = new Group("Group1", students);
        Student expectedStudent1 = group.getStudents()[1];
        Student expectedStudent2 = group.getStudents()[0];
        Student expectedStudent3 = group.getStudents()[3];
        Student expectedStudent4 = group.getStudents()[2];

        group.sortStudentsByName();
        Student actualStudent1 = group.getStudents()[0];
        Student actualStudent2 = group.getStudents()[1];
        Student actualStudent3 = group.getStudents()[2];
        Student actualStudent4 = group.getStudents()[3];

        assert expectedStudent1.equals(actualStudent1):"sortStudents test failed with Student 1. " +
                "\nActual student: " + actualStudent1.toString() +
                "\nExpected student: " + expectedStudent1.toString();
        assert expectedStudent2.equals(actualStudent2):"sortStudents test failed with Student 2. " +
                "\nActual student: " + actualStudent2.toString() +
                "\nExpected student: " + expectedStudent2.toString();
        assert expectedStudent3.equals(actualStudent3):"sortStudents test failed with Student 3. " +
                "\nActual student: " + actualStudent3.toString() +
                "\nExpected student: " + expectedStudent3.toString();
        assert expectedStudent4.equals(actualStudent4):"sortStudents test failed with Student 4. " +
                "\nActual student: " + actualStudent4.toString() +
                "\nExpected student: " + expectedStudent4.toString();



    }


}
