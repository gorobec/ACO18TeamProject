package ACO.week1.students.comparators;

import ACO.week1.students.Student;

import java.util.Comparator;

/**
 * Created by v21k on 28.01.17.
 */
public class ByNameComparator implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        Student s1 = (Student) o1;
        Student s2 = (Student) o2;
        return s1.getName().compareTo(s2.getName());
    }
}
