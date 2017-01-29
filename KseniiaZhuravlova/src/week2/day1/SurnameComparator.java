package week2.day1;

import week1.day1.Student;

import java.util.Comparator;

/**
 * Created by ksyashka on 28.01.2017.
 */
public class SurnameComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Student st1 = (Student) o1;
        Student st2 = (Student) o2;

        return st1.getSurname().compareTo(st2.getSurname());
    }
}
