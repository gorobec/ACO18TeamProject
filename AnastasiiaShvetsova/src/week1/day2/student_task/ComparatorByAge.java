package week1.day2.student_task;

import java.util.Comparator;

/**
 * Created by Nastia on 28.01.17.
 */
public class ComparatorByAge implements Comparator {

    @Override
    public  int compare(Object obj1, Object obj2){
        Student student1 = (Student) obj1;
        Student student2 = (Student) obj2;
        return Integer.compare(student1.getAge(), student2.getAge());

    }
}
