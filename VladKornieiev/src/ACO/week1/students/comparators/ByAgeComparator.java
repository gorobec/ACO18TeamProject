package ACO.week1.students.comparators;

import ACO.week1.students.Student;

import java.util.Comparator;

/**
 * Created by v21k on 28.01.17.
 */
public class ByAgeComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Student student1 = (Student) o1;
        Student student2 = (Student) o2;
        return Integer.compare(student1.getAge(), student2.getAge());
    }
}
