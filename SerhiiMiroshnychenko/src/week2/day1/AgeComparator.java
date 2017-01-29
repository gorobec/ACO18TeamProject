package week2.day1;

import week1.day1.Student;

import java.util.Comparator;

/**
 * Created by serhiim on 28-Jan-17.
 */
public class AgeComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Student student1 = (Student) o1;
        Student student2 = (Student) o2;
        return Integer.compare(student1.getAge(), student2.getAge());
    }
}
