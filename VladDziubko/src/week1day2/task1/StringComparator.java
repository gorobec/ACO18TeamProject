package week1day2.task1;

import java.util.Comparator;

/**
 * Created by Reed on 29.01.2017.
 */
public class StringComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Student student = (Student) o1;
        Student student1 = (Student) o2;
        return student.getName().compareTo(student.getName());
    }
}
