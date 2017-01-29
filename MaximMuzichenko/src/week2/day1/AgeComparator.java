package week2.day1;

import week1.day2.student_task.Student;

import java.util.Comparator;

/**
 * Created by gorobec on 28.01.17.
 */
public class AgeComparator implements Comparator{


    @Override
    public int compare(Object o1, Object o2) {
        Student student = (Student) o1;
        Student student2 = (Student) o2;
        return Integer.compare(student.getAge(),student2.getAge());
    }
}
