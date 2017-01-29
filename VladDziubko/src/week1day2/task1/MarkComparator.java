package week1day2.task1;


import java.util.Comparator;

public class MarkComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Student student = (Student) o1;
        Student student1 = (Student) o2;
        return Double.compare(student.getAverageMark(), student1.getAverageMark());
    }
}
