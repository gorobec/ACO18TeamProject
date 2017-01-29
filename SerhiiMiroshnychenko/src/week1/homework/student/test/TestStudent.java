package week1.homework.student.test;

import week1.homework.student.Student;

/**
 * Created by serhiim on 24-Jan-17.
 */
public class TestStudent {

    public static void main(String[] args) {
        testStudentToString();
    }

    private static void testStudentToString(){
        Student student1 = new Student("qwe", "ewq", 23);
        String expected = "Student name - qwe, student surname - ewq, age - 23";
        String actual = student1.toString();
        assert actual.equals(expected):"studentToString test failed. \nActual: " + actual + "\nExpected: " + expected;
    }
}
