package week2.day1;

import week1.day2.student_task.Student;

import java.util.Comparator;

/**
 * Created by gorobec on 04.02.17.
 */
public class NameComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Student st1 = (Student) o1;
        Student st2 = (Student) o2;
        return st1.getName().compareTo(st2.getName());
    }
}
