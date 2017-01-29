package week1.classWork;

import java.util.Comparator;

/**
 * Created by Игорь on 28.01.2017.
 */
public class SurnameComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Student student1 = (Student) o1;
        Student student2 = (Student) o2;
        return student1.compareTo(student2);
    }
}
