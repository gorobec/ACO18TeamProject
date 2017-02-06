package week1.day1;

import java.util.Comparator;

/**
 * Created by User on 28.01.2017.
 */
public class SurNameComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Student st1 = (Student) o1;
        Student st2 = (Student) o2;

        return st1.getSurName().compareTo(st2.getSurName());
    }
}
