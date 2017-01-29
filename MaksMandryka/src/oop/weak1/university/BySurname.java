package oop.weak1.university;

import java.util.Comparator;

/**
 * Created by fmandryka on 28.01.2017.
 */
public class BySurname implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {

        Student s1 = (Student) o1;
        Student s2 = (Student) o2;

        return s1.getSurname().compareTo(s2.getSurname());

    }
}
