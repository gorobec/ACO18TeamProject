package ACO.week1.students.comparators;

import ACO.week1.students.Student;

import java.util.Comparator;

/**
 * Created by v21k on 28.01.17.
 */
public class BySurnameComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Student s1 = (Student) o1;
        Student s2 = (Student) o2;
        return s1.getSurname().compareTo(s2.getSurname());

    }
}
